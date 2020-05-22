public void TestMethod()
 {
     Test= new Thread(new Runnable() {
         public void run() {
             try{
                Catch(); 
             }
             catch (Exception ioe) 
             {

             }

         }
     });
     Test.start();
 }
public void Catch()
 {
     activity.runOnUiThread(new Runnable() {
         public void run() {
             try{
                 Toast.makeText(getApplicationContext(), "Yes", Toast.LENGTH_SHORT).show();
             }
             catch (Exception ioe) 
             {

             }

         }
     });

 }