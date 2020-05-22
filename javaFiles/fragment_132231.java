class JavaClass {

    private:
        jclass cls;
        JNIEnv *env;

    public:
        JavaClass(JNIEnv *env, const char *className) {
            this.env = env;
            cls = env->FindClass(className);
            // handle errors
        }

        ~JavaClass() {
            env->DeleteLocalRef(cls);
        }

        bool isInstanceOf(jobject obj) {
            return env->IsInstanceOf(obj, cls);
        }
};