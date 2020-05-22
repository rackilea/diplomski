try {
        out = new PrintStream(new FileOutputStream("filename.txt"));
        out.print(first_input);
        }
        catch(FileNotFoundException e) {
        //do something in the event that a FNFE is thrown
        }
        finally {
        if (out != null) out.close();
    }
}