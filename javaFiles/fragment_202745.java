(exec ./modules/gradlew -p modules build jar publishToMavenLocal);  gradlew_return_code=$?

if [ "$gradlew_return_code" -eq "0" ]; then
    echo "Gradle build task success!"
else
    echo "Gradle build task failed with return code $gradlew_return_code; aborting."
    exit -1
fi