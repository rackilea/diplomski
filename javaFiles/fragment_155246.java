//Initialize  globally
Random ran = new Random();

int randomNum = ran.nextInt(4 - 1) + 1;
//This gives a random integer between 1 (inclusive) and 4 (exclusive), one of 1,2 and 3.

 if(randomNum == 1) {
       Intent i = new Intent(getApplicationContext(), ActivityOne.class);  
       startActivity(i);  
   }else if(randomNum == 2) {
       Intent i = new Intent(getApplicationContext(), ActivityTwo.class);  
       startActivity(i);  
  }