public class OuterClass {

    public static void main(String[] args) {
        OuterClass.MyStaticClass myStaticClassOne = new OuterClass.MyStaticClass();
        OuterClass.MyStaticClass myStaticClassTwo = new OuterClass.MyStaticClass();
        OuterClass.MyStaticClass myStaticClassThree = new OuterClass.MyStaticClass();
        myStaticClassOne.setInstanceInt(10);
        myStaticClassTwo.setInstanceInt(20);
        System.out.println("staticInt: " + MyStaticClass.staticInt);
        System.out.println("instanceIntOne: " + myStaticClassOne.getInstanceInt());
        System.out.println("instanceIntTwo: " + myStaticClassTwo.getInstanceInt());
        System.out.println("instanceIntThree: " + myStaticClassThree.getInstanceInt());

    }

    static class MyStaticClass {
        static int staticInt = 5;
        int instanceInt = 6;

        public int getInstanceInt() {
            return instanceInt;
        }

        public void setInstanceInt(int instanceInt) {
            this.instanceInt = instanceInt;
        }
    }
}