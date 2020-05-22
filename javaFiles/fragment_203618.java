class MyValues{
    public int i = 1;
    private String value = null;

    public MyValues(String v){
        value = v;
    }

    int hashCode()
    {
        return value.length;
    }

    boolean equals(Object obj){
        return obj.equals(value);
    }
}