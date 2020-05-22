while (true) {
    try {
        //Retrieve the lines
        String line = secondBlockingQueue.take();
        if (line==SINGLE_POISIN_PILL) {

            setCounter(getCounter()+1);
            if (getCounter()== threadNumber) {
                System.out.println("All "+getCounter()+" threads have finished.  \n Stopping..");
                return;
            }
        }

        try {
            if (line != SINGLE_POISIN_PILL) {
                System.out.println(line);
                bufferedWriter.write(line+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } catch (InterruptedException e) {
        e.printStackTrace();
    } 
}