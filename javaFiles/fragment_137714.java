long lastCall = 0L; //Initializing 

public void onMessage(String channel, String sender,
        String login, String hostname, String message) {

   if (message.equalsIgnoreCase("!Scouter")) {
       if(System.currentTimeMillis() - lastCall >= 5000)
       {
           lastCall = System.currentTimeMillis(); // Set lastCall again
           sendMessage(channel,": The time is now " + sender + number);
           for(int counter=1; counter<=1;counter++) {
             number = 1+dice.nextInt(9001);
             System.out.println(number + " ");
           }
       }
   }
}