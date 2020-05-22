public class MyClass {
    //I define the class here^^

    //Public function
    public static void main(String args[]) {

        //Here in the main function I will call the sleepIn 

        boolean sleepin = sleepIn(true,true);

        //I am setting weekday and vacation to true, it should in return print true
        System.out.println(sleepin); //It prints TRUE


    }

    //Your sleepIn function
    public static boolean sleepIn(boolean weekday, boolean vacation){
        if (weekday == true && vacation == true){

            //Here the function returns true (boolean)

            return true;
        }

        //The function returns false (boolean)

        return false;
    }
}