auto textureName = 1; // Should be retrieved using glGenTextures() function
auto textureWidth = 512;
auto textureHeight = 512;

// Retrieve the JNI environment, using SDL, it looks like that
auto env = (JNIEnv*)SDL_AndroidGetJNIEnv();

// Create a SurfaceTexture using JNI
const jclass surfaceTextureClass = env->FindClass("android/graphics/SurfaceTexture");
// Find the constructor that takes an int (texture name)
const jmethodID surfaceTextureConstructor = env->GetMethodID(surfaceTextureClass, "<init>", "(I)V" );
jobject surfaceTextureObject = env->NewObject(surfaceTextureClass, surfaceTextureConstructor, textureName);
jobject jniSurfaceTexture = env->NewGlobalRef(surfaceTextureObject);

// To update the SurfaceTexture content
jmethodId updateTexImageMethodId = env->GetMethodID(surfaceTextureClass, "updateTexImage", "()V");
// To update the SurfaceTexture size
jmethodId setDefaultBufferSizeMethodId = env->GetMethodID(surfaceTextureClass, "setDefaultBufferSize", "(II)V" );

// Create a Surface from the SurfaceTexture using JNI
const jclass surfaceClass = env->FindClass("android/view/Surface");
const jmethodID surfaceConstructor = env->GetMethodID(surfaceClass, "<init>", "(Landroid/graphics/SurfaceTexture;)V");
jobject surfaceObject = env->NewObject(surfaceClass, surfaceConstructor, jniSurfaceTexture);
jobject jniSurface = env->NewGlobalRef(surfaceObject);

// Now that we have a globalRef, we can free the localRef
env->DeleteLocalRef(surfaceTextureObject);
env->DeleteLocalRef(surfaceTextureClass);
env->DeleteLocalRef(surfaceObject);
env->DeleteLocalRef(surfaceClass);

// Don't forget to update the size of the SurfaceTexture
env->CallVoidMethod(jniSurfaceTexture, setDefaultBufferSizeMethodId, textureWidth, textureHeight);

// Get the method to pass the Surface object to the WebView
jmethodId setWebViewRendererSurfaceMethod = env->GetMethodID(webViewClass, "setWebViewRendererSurface", "(Landroid/view/Surface;)V");
// Pass the JNI Surface object to the Webview
env->CallVoidMethod(webView, setWebViewRendererSurfaceMethod, jniSurface);