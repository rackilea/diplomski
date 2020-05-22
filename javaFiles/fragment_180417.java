public class StaticAndInnerClasses {
    String testString;
    class InnerClass{
        int x;
        int y;

        public void printString() {
            changeCharacter();
            System.out.println(testString);
        }
    }

    static class InnerStaticClass{
        int a=10;
        int b=20;

    }
    public void changeCharacter(){
        testString="Characters modified";
    }

    public static void main(String[] args){
        StaticAndInnerClasses.InnerStaticClass statciClassObject=new StaticAndInnerClasses.InnerStaticClass();
        StaticAndInnerClasses outerObject=new StaticAndInnerClasses();
        StaticAndInnerClasses.InnerClass innerClassObject=outerObject.new InnerClass();
        innerClassObject.printString();

    }
}