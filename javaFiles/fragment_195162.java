public void run() {
    while(true){
        try {


               incomingMessages.addAll(fullPoll());
                System.out.println("waiting 6 seconds");

                //perform this operation in a loop
                Thread.sleep(6000);

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
    //  System.out.println(sdf.format(currentDate) + " " + msg);
   }
}