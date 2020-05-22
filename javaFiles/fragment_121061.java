public static void main(String args[]) {
        try {
            Thread thr = new Thread(new fileReader());

            thr.start();
            thr.join();

            System.out.println("File one has " + count + " lines");
            System.out.println("File two has " + count1 + " lines");
        } catch (InterruptedException ex) {
            Logger.getLogger(fileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }