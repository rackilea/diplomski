class Something{
    public void example(){
        int value=1;
        System.out.println("value from before a block: "+value);
            {
                value=2;
                System.out.println("value from inside a block: "+value);
            }
        System.out.println("value from after a block: "+value);
    }
}