public static void main(String[] args) {

    Scanner keyboard=new Scanner(System.in);

    System.out.println("Enter file name to be written");
    String file=keyboard.next();

    File fileName=new File(file);

    try{
        FileOutputStream fo=new FileOutputStream(fileName);
        ObjectOutputStream output=new ObjectOutputStream(fo);

        System.out.println("Enter numbers");
        System.out.println("enter q to quit");

        String number;

        do
        { 
            number=keyboard.next();
            if(number.equals("q")){
                output.writeUTF(number);
            }
            else{
                double new_number = Double.parseDouble(number);
                output.writeDouble(new_number);
            }   
        }
        while (!number.equals("q"));

        if(number.equals("q")){
            System.out.println("numbers were written to: "+fileName);
            output.close();
            fo.close();
        }
    }
    catch(FileNotFoundException e){
    }
    catch(IOException e){

    }

    double num=0;
    double num2=0;
    double num_check=0;
    double num3=Double.MAX_VALUE;
    int count=0;
    System.out.println("Now the program starts");

    try{
        FileInputStream fi=new FileInputStream(fileName);
        ObjectInputStream input=new ObjectInputStream(fi);
        double num_ave=0;
        long file_length=fileName.length();

        for(int i=0;i<file_length;i++){

            num=input.readDouble();
            if(num>=0){
            //System.out.println(num);
            num_ave+=num;
            }
            if(num>num_check){
                num_check=num;
            }
            if(num<num3){
                num3=num;
            }
            count++;

        //Here is my attempt at getting the average


        double average=num_ave/count;
        System.out.println(average);
        System.out.println("Average of all the numbers is: "+average);
        }
        input.close();
        fi.close();
    }

    catch(FileNotFoundException e){  
    }
    catch(EOFException e){

        System.out.println("Largest number: "+num_check);
        System.out.println("Smallest number: "+num3);

    }
    catch(IOException e){  
    }
}