class FunctionWrapper
{
public:
    typedef double (FunctionWrapper::*Function1VariablePtr)(double x);

    FunctionWrapper(JNIEnv*, jclass);
    double compute(double x);
};