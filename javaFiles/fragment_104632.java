class Untitled {

    public static void main(String[] args) 
    {
        U.log("test");
        U.log(45);
    }

    // U(tility)
    public static class U
    {
        public static void log( Object o )
        {
            System.out.println( o.toString() );            
        }
    }
}