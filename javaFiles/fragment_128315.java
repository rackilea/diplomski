public static void main(String[] args) 
{
   Thread t1 = new Thread(new Runnable() {
       public void run() {
           takeInfofromDB(); 
           doSomeLongCalculationsWithThatData();
       }});

   Thread t2 = new Thread(new Runnable() {
       public void run() {
         takeInfofromDB2();
         doSomeLongCalculationsWithThatData2();
       }});

   t1.start();
   t2.start();

   t1.join();
   t2.join();

   GenerateAnswerFromBothAnswers();
}