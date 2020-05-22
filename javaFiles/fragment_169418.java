JNIEXPORT jintArray JNICALL  Java_com_example_user_activity_MainActivity_generateAssets(JNIEnv* env, jobject thiz, jobject assetManager) {
AAssetManager *mgr = AAssetManager_fromJava(env, assetManager);
AAsset *img = AAssetManager_open(mgr, "hi.jpg", AASSET_MODE_UNKNOWN);

long sizeOfImg = AAsset_getLength(img);
char* buffer = (char*)AAsset_getBuffer(img);

std::vector<char> data(buffer, buffer + sizeOfImg);

cv::Mat h = cv::imdecode(data, IMREAD_UNCHANGED);

jintArray resultImage = env->NewIntArray(h.total());
jint *_data = new jint[h.total()];
for (int i = 0; i < h.total(); i++) {
    char b = h.data[h.channels() * i];
    char g = h.data[h.channels() * i + 1];
    char r = h.data[h.channels() * i + 2];
    char a = 255;
    _data[i] = (((jint) a << 24) & 0xFF000000) + (((jint) r << 16) & 0x00FF0000) +
               (((jint) g << 8) & 0x0000FF00) + ((jint) b & 0x000000FF);
}
env->SetIntArrayRegion(resultImage, 0, h.total(), _data);
delete[]_data;
return resultImage;