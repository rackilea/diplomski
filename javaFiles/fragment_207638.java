char[] c  = myString.toCharArray();
boolean good = true;

for(int i = 3 ; i < c.length ; i+=2){
    if(c[i] != c[i-2]){
        good = false;
        break;
    }
}     

if(good) System.out.println("GOOD");
else System.out.println("BAD");