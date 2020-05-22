/*Display the double Array*/
       public static void displayDoublesArray(){
        String delimiter;
        Arrays.sort(doubles);
        System.out.println("The double array: ");
        // iterate through all the array elements

        StringBuilder buff = new StringBuilder(); // use buffer 

        buff.append("{");
        for(int i=0;i<SIZE;i++) { 
           if(i < SIZE-1){
               delimiter = ", ";
           }
           else{
               delimiter = "}";
           }
           buff.append(doubles[i]+ delimiter);                  
        } 

        buff.append("\n");

        System.out.println(buff.toString());
    }