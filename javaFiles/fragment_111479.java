public abstract class Demo{

    public Demo(){}


    public void display(){
        System.out.println( "this is from abstract class" );
    }


    public static void main( String[] args ){
        Demo s = new Demo(){
            public void display(){
                System.out.println( "this is demo constructor" );
            }
        };
        s.display();
    }
}