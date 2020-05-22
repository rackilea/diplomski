extern "C" JNIEXPORT jstring JNICALL
Java_com_example_rsolver_Solver_string(JNIEnv *env, jobject object,jstring string) {
    // Converting Java String into C++ String and 
    // calling a "solution" method and passing c++ string
    std::string tmp{jstring2string(env,string)};
    return solution(&tmp);
}