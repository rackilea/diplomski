double sum = 0; //average will have decimal point

for(int i=0; i < args.length; i++){
   //parse string to double, note that this might fail if you encounter a non-numeric string
   //Note that we could also do Integer.valueOf( args[i] ) but this is more flexible
   sum += Double.valueOf( args[i] ); 
}

double average = sum/args.length;

System.out.println(average );