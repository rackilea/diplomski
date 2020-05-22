#!/usr/bin/env bash
# Or plug in `zsh` instead of `bash` above if that is your preferred shell

DIR=$(pwd)
cd "$DIR"
APPLICATION_NAME="App Name"

echo -n "Locating Java ... "

PLATFORM=$(uname)
JAVA_PATH="java"
JAVA_VER=$($JAVA_PATH -version 2>&1 | sed 's/java version "\(.*\)\.\(.*\)\..*"/\1\2/; 1q')

if [[ "$JAVA_VER" == *"command not found"* ]]; then
    echo "Java not found."
else
    JAVA_VER_FULL=$($JAVA_PATH -version 2>&1 | awk -F '"' '/version/ {print $2}')

    if [[ $JAVA_VER -eq 17 ]]; then
        echo "v1.7 found."

        if [[ $PLATFORM -eq "Darwin" ]]; then
            echo "[!!!] WARNING: Java v1.7 on OS X is known to have problems with ${APPLICATION_NAME}."
            echo -n "Looking for compatible version of Java ... "

            JAVA_PATH="/System/Library/Frameworks/JavaVM.framework/Versions/1.6/Home/bin/java"
            if [[ -f "$JAVA_PATH" ]]; then
                JAVA_VER=$($JAVA_PATH -version 2>&1 | sed 's/java version "\(.*\)\.\(.*\)\..*"/\1\2/; 1q')
                JAVA_VER_FULL=$($JAVA_PATH -version 2>&1 | awk -F '"' '/version/ {print $2}')
                if [[ $JAVA_VER -eq 16 ]]; then
                    echo "$JAVA_VER_FULL found. Using this version."
                else
                    echo "No known compatible versions of Java could be found. ${APPLICATION_NAME} may not run properly, or at all."
                fi
            fi
        else
            echo "$JAVA_VER_FULL found."
        fi
    else
        echo "$JAVA_VER_FULL found."
    fi
fi

echo ""


echo "Starting ${APPLICATION_NAME}..."


# Insert the java application or jar that you wish to execute here prepended by `$JAVA_PATH` instead of simply `java`
# For example:
#
# $JAVA_PATH -jar /path/to/the/application.jar