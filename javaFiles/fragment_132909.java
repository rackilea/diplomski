public class ExampleClass{
    int number;
    public ExampleClass(String number){
        try{
            //If you want to convert into int
            this.number = Integer.parseInt(number);
        }catch(NumberFormatException e){
            System.out.println("Wrong input");
        }
    }

    public void checkMethod(){
        if(number > 5){
            System.out.println("Number is greater.");
        }else{
            System.out.println("Number is lesser.");
        }
    }
}