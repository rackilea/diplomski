private Set<MyValues> values = new TreeSet<MyValues>();
for(String s : duplicatArray){
    MyValues v = new MyValues(s);
    if (values.add(v))
    {
        v.i++;
    }
}