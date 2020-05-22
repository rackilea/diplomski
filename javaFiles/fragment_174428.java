for(i=0;i<polinom.length();i++){ // not using -1, looping to the end of the string
    if(polinom.charAt(i)=='+' && i < polinom.length() - 1) // checking that no exception will be thrown
        c=polinom.charAt(i+1);
    else{
       if(polinom.charAt(i)=='^' && i < polinom.length() - 1){ // same
           v=Integer.parseInt(Character.toString(polinom.charAt(i+1)));
           coef1[v]=-Integer.parseInt(Character.toString(c));
           System.out.print(coef1[v]);
        }
   }
}