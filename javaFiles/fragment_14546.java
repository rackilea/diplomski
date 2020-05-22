if(c.getCount()>0 && c2.intValue() < 100000){
   Toast.makeText(getApplicationContext(), "This purchase was made.", Toast.LENGTH_LONG).show();
} else {
   if(c2.intValue() >= 100000){
       Toast.makeText(getApplicationContext(), "You have reached the maximum amount of purchases.", Toast.LENGTH_LONG).show();
   } 
   ...
   ...
}