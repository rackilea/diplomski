class Module4 {
    Module4 (int x) { 
        System.out.println("1st instance init");
        System.out.println("2nd instance init");
        System.out.println("1-arg const"); 
    }
    Module4 () { 
        System.out.println("1st instance init");
        System.out.println("2nd instance init");            
        System.out.println("No-arg const"); 
    }
    static { System.out.println("First static init"); }
    //{ System.out.println("1st instance init"); }
    //{ System.out.println("2nd instance init"); }
    static { System.out.println("2nd static init"); }

    public static void main(String[] args)
    {
        new ModuleInit();
        new ModuleInit(8);
    }
}