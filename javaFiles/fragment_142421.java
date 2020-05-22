public static void verifyVariableIsNotEqualTo(Object variable, Object otherVariable, boolean considerBothNullAsEqual) throws Exception
{
    if(considerBothNullAsEqual && variable == null && otherVariable == null)
    {
        throw new Exception("not allowed to be equal");
    }

    if(variable != null && variable.equals(otherVariable))
    {
        throw new Exception("not allowed to be equal");
    }
}