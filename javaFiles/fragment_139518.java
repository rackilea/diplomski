if (line==SINGLE_POISIN_PILL) {
            setCounter(getCounter()+1);
            if (getCounter()== threadNumber) {
                System.out.println("All "+getCounter()+" threads have finished.  \n Stopping..");
                try {
         if (bufferedWriter != null) 
         {
             bufferedWriter.flush();
             bufferedWriter.close();
         }
     } catch (IOException e) {
         e.printStackTrace();
     }
                return;
            }
        }