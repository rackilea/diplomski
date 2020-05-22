if [ -x /usr/libexec/java_home ]; then
    // note that the extra parentheses are removed
    export JAVA_HOME=$(/usr/libexec/java_home)
else
    export JAVA_HOME=/Library/Java/Home
fi