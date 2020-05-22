protected void onPostExecute(Object result) {
     synchronized(staticInt) {
        --staticInt;
        if (staticInt == 0) {
           //show message
        }
     }
 }