public class Shadow {

        private int myIntVar = 0;

        public void shadowTheVar(){

            // since it has the same name as above object instance field, it shadows above 
            // field inside this method
            int myIntVar = 5;

            // If we simply refer to 'myIntVar' the one of this method is found 
            // (shadowing a seond one with the same name)
            System.out.println(myIntVar);

            // If we want to refer to the shadowed myIntVar from this class we need to 
            // refer to it like this:
            System.out.println(this.myIntVar);
        }

        public static void main(String[] args){
            new Shadow().shadowTheVar();
        }
    }