echo "starting generate apk file"
 echo "****************************************"
 ./gradlew  assembleDebug
APK_NAME=${BUILD_NUMBER}
FILE_PATH="/var/lib/jenkins/workspace/android-app-automation/app/build/outputs/apk/debug/"
FILE="/var/lib/jenkins/workspace/android-app-automation/app/build/outputs/apk/debug/app-debug.apk"
if test -f "$FILE"; then
    echo "APK build successfully"
    mv $FILE "${FILE_PATH}${APK_NAME}.apk"
    exit 0
else
    echo "Job failed to create APK... see logs"
    exit 1
fi