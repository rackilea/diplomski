public class ClassSwitch {
    static final class Foo {}
    static final class Bar {}
    static final class Baz {}

    public static void main(String... arg) {
        Class<?> cl=Bar.class;
        switch(cl.getSimpleName().hashCode()) {
            case 70822: 
                if(cl==Foo.class) {
                    System.out.println("case Foo:");
                }
                break;
            case 66547: 
                if(cl==Bar.class) {
                    System.out.println("case Baz:");
                }
                break;
            case 66555: 
                if(cl==Baz.class) {
                    System.out.println("case Baz:");
                }
                break;
        }
    }
}