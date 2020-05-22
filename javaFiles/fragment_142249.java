QAndroidJniObject ACTION_GET_CONTENT = QAndroidJniObject::fromString("android.intent.action.GET_CONTENT");
QAndroidJniObject intent("android/content/Intent");
if (ACTION_GET_CONTENT.isValid() && intent.isValid()) {
    intent.callObjectMethod("setAction", "(Ljava/lang/String;)Landroid/content/Intent;", ACTION_GET_CONTENT.object<jstring>());
    intent.callObjectMethod("setType", "(Ljava/lang/String;)Landroid/content/Intent;", QAndroidJniObject::fromString("file/*").object<jstring>());
    QtAndroid::startActivity(intent.object<jobject>(), EXISTING_FILE_NAME_REQUEST, receiver);
    return true;
} else {
    return false;
}