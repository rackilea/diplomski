JNIEXPORT jlong JNICALL Java_mpiJNI_mpiTEST(JNIEnv *env, jobject obj) {
   MPI::Request *req = new MPI::Request[8]; // Don't forget to release memory leater

   uintptr_t storage = (uintptr_t)ptr

   return (jlong) storage;
}