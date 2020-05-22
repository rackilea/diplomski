public class MyObjectValidator extends ClassValidator<MyObject>
{
    public MyObjectValidator()
    {
         super(MyObject.class);
    }

    public InvalidValue[] getInvalidValues(MyObject myObj)
    {
        List<InvalidValue> invalids = new ArrayList<InvalidValue>();
        invalids.addAll(Arrays.asList(super.getInvalidValues(myObj)));

        // add custom validations here
        invalids.addAll(validateDynamicStuff(myObj));

        InvalidValue[] results = new InvalidValue[invalids.size()];
        return invalids.toArray(results);
    }

    private List<InvalidValue> validateDynamicStuff(MyObject myObj)
    {
        // ... whatever validations you want ...
    }

}