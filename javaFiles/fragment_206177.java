public static void main(String[] args)
{
    LinkedHashMap<Integer,LinkedHashMap<Integer,String>> values = new LinkedHashMap<Integer,LinkedHashMap<Integer,String>>();
    LinkedHashMap<Integer,String> innerValues = new LinkedHashMap<Integer,String>();
    innerValues.put(1, "FirstSetValue1");
    innerValues.put(2, "FirstSetValue2");

    values.put(1, innerValues);
    System.out.println(values);

    innerValues = new LinkedHashMap<Integer,String>();
    innerValues.put(1, "SecondSetValue1");
    innerValues.put(2, "SecondSetValue1");

    values.put(2, innerValues);
    System.out.println(values);
}