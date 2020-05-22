public class Child extends Parent {

    private @Annotation String test;

    public Child() {
        System.out.println( this.test );
    }

    public static void main( final String[] args ) {
        new Child();
    }

}