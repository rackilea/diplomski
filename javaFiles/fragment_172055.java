protected void doInBackground() throws Exception {

      // code to be called off of the EDT

      SwingUtilities.invokeLater(new Runnable() {
         public void run() {

            // code to be called on the EDT

         }
      });
      return null;
   }