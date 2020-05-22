public class ReflectFoo2Class {
    public ReflectFoo2Class(){
            Foo2 f = new Foo2();
                    Field[] field;
            try {
                           field = f.getClass().getFields();
                           for(Field fa: field){
                                System.out.println(fa.getName());
                            }
            } catch (Exception e) {
                e.printStackTrace();
            }           
        }
        public static void main(String[]args){
            new ReflectFoo2Class();
        }
     }
class Foo2 {
        public String v = "";
        public String v1 = "";
        public String v2 = "";
    public void print() {
        System.out.println("abc");
    }
}