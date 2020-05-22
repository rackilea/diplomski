// sometimes the compiler complains if there was a scanner opened without a try-catch block around it
try {
            final File FILE1 = new File("text1.txt"); //it is always a good thing to make a file as final, it gives an easy reference for the reader 
            final File FILE2 = new File("text2.txt");
            Scanner t1 = new Scanner(FILE1);
            Scanner t2 = new Scanner(FILE2);
            //after you are done close the scanner
            t1.close();
            t2.close();
        } catch (FileNotFoundException ex) {
        }