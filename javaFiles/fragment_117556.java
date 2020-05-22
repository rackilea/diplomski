public class App{

    public static void main( String[] args ){
        new App();
        new App();
    }

    static{
        System.out.println( "static initializer" );
    }

    public App(){
        System.out.println( "constructor" );
    }

    {
        System.out.println( "instance initializer" );
    }
}