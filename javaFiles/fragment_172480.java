int max = Integer.MIN_VALUE;
while(inputfile.hasNext()) {
     int compare = inputfile.nextInt();
     if (compare > max){
         max = compare;
     }
}
System.out.println("highest value:"+ max);