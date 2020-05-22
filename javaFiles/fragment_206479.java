public class Test extends PracticeParent {  //No Error
        public static void main(String[] args) {
            PracticeParent pp=new PracticeParent();     //Error. The constructor PracticeParent() is not visible
            Test t=new Test();     //outputs "PracticeParent default constructor"
        }
    }