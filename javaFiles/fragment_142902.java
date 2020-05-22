class B
{
    private HashMap<String,A> theAs=new HashMap<String,A>(); //give better name


    public B ()
    {
        theAs.put("a1",new A ("a1")); //A probably doesn't need to keep its own name internally now, but have left it as its in your original code
        theAs.put("a2",new A ("a2"));
        theAs.put("a3",new A ("a3"));
    }

    public A get_A_byName (String name)
    {
        return theAs.get(name);
    }
}