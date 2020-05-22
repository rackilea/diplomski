public class Parent {

    private @Annotation String testOfParent;

    public Parent() {
        for ( int i = 0; i < this.getClass().getDeclaredFields().length; i++ ) {
            Field field = this.getClass().getDeclaredFields()[i];
            System.out.println( field );

            for ( int j = 0; j < field.getDeclaredAnnotations().length; j++ ) {
                java.lang.annotation.Annotation annotation = field.getDeclaredAnnotations()[j];
                System.out.println( annotation );
            }

            try {
                field.setAccessible( true );
                field.set( this, "Hello World!" );
            } catch ( IllegalArgumentException | IllegalAccessException ex ) {
                // TODO Auto-generated catch block
                ex.printStackTrace();
            }
        }

    }
}