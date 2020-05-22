class InitBlocksDemo {

    private String name ;

    InitBlocksDemo(int x) {
        System.out.println("In 1 argument constructor, name = " + this.name);
    }

    InitBlocksDemo() {
        name = "prasad";
        System.out.println("In no argument constructor, name = " + this.name);

    }

    /* First static initialization block */
    static {
        System.out.println("In first static init block ");
    }

    /* First instance initialization block  */
    {
        System.out.println("In first instance init block, name = " + this.name);
    }

    /* Second instance initialization block */
    {
        System.out.println("In second instance init block, name = " + this.name);
    }

    /* Second static initialization block  */
    static {
        System.out.println("In second static int block ");
    }

    public static void main(String args[]) {
        new InitBlocksDemo();
        new InitBlocksDemo();
        new InitBlocksDemo(7);
    }

}