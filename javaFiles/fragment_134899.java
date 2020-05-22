public class ClassB extends ClassA{

        public void BMessage(){
            AMessage(); 
        }
        public static void main(String[] args){
            new ClassB().BMessage();
        }
    }