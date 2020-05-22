class A1
{
    static class A11
    {
        public
            final // WHAT IS THE EFFECT OF THIS MODIFIER?
            void fun ( String caller )
            {
                System . out . println ( "A11:\t" + caller ) ;
            }
    }

    static class A12 extends A11
    {
        public void fun ( String caller )
        {
            super . fun ( caller + caller ) ;
        }
    }

    public static void main ( String [ ] args )
    {
        A12 a12 = new A12 ( ) ;
        a12 . fun ( "Hello" ) ;
    }
}