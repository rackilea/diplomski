private static void validate(Object arg)
{
    if (arg instanceof A) {
        validate((A) arg);
    }
    else if (arg instanceof B) {
        validate((B) arg);
    }
    else {
        throw new RuntimeException("Don't know how to validate object of class " + arg.getClass.getName());
    }
}