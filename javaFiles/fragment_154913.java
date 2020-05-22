static void plusMinus(int[] arr) {
    float pos = 0, neg = 0, zero = 0;
    float arrlength = arr.length;

    for(int i = 0; i < arrlength; i++){

       if(arr[i] > 0){
           pos += 1;
       } else if(arr[i] < 0){
           neg += 1;
       } else if(arr[i] == 0){
           zero += 1;
       }
     }

double posfrac = pos/arrlength , negfrac = neg/arrlength , zerofrac = 
zero/arrlength ;

System.out.println(posfrac);
System.out.println(negfrac);
System.out.println(zerofrac);
}