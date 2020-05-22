#! /usr/bin/bash
# Eclipse CLI program launcher.

# ----------------------------------------------------------
# Constants
# ----------------------------------------------------------

# Main class
CLASS=your.main.class.Here

# ----------------------------------------------------------
# Parse arguments
# ----------------------------------------------------------
# Debugger mode ?
if [ "$1" = "debug" ]
then
    shift
    DEBUG_OPTIONS="-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,address=3409,suspend=y"
fi

# -------------------------------------------------------
# Setup the classpath from eclipse .classpath files
# -------------------------------------------------------

# Init classpath
CLASSPATH=""

# Process a single .classpath file
# This is a recursive function
# Arguments:
#  $1 : Dir path where to search for a ".classpath" file
function build_classpath() {

    # Aliases to arguments
    local folder="$1"
    local file="$folder/.classpath"

    # ".classpath" file does not exists ? => exit
    if [ ! -f "$file" ]
    then
        return
    fi

    # Parse the file with sed
    # return a list of <type>:<path> pairs
    local lines=`sed -ne 's/^.*kind="\(.*\)"\s\s*path="\(.*\)".*$/\1:\2/gp' $file`

    # Loop on lines
    for line in $lines
    do
        # Split the type and path values
        local type=${line%:*}
        local path=${line#*:} 

        # Switch on type
        case $type in

            "lib" )
                CLASSPATH=$CLASSPATH:$folder/$path
                ;;

            "output" )
                CLASSPATH=$CLASSPATH:$folder/$path
                ;;

            "src" )
                # Recursive call for other projects, relative to the workspace (the parent dir)
                build_classpath "..$path"
                ;;
        esac

    done
}

# Start building the classpath from the current project dir
build_classpath .

# Call java
java  $DEBUG_OPTIONS -Xmx1024m -cp `cygpath -wp $CLASSPATH` $CLASS $@