public static void sumInputs(){
    Scanner data=new Scanner(System.in);
    ArrayList <Double> allNumbers=new ArrayList<>();
    while(true){
        System.out.print("Number:");
        try{
            //IMPORTANT: Notice I use "nextLine" and not "next", because next will wait till user inputs something not null
            //and ignours the "enter" key pressed, while "nextLine" executes when the user presses the key "enter" regardless
            //of whether there is input.
            //I would imagine this is your problem
            String number=data.nextLine();

            //The part you are looking for
            //Right here is the part you are looking for
            if(!number.isEmpty()){
                //what to do if it is not null (store the numbers
                //in an ArrayList).
                allNumbers.add(Double.parseDouble(number));
            }else{
                //add up all the numbers if it is null
                double sum = 0;
                for( double i : allNumbers) {
                    sum += i;
                }
                System.out.println("The result is "+ sum);
                System.exit(0);
            }
        }catch(InputMismatchException e){
            System.out.println("Not number");
        }
    }
}