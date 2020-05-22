private static Integer[] keys=new Integer[]{1,2,3};
private static String[] values=new String[]{"first","second","third"};

private static Map<Integer,String> myMap;
{
    myMap=mapFromArrays(keys, values);
}