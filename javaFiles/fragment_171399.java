public  void myMethod() throws IOException
{
    FileInputStream fistream1 = new FileInputStream(newFile1 );  // first source file
    FileInputStream fistream2= new FileInputStream(newFile2 );//second source file
    Vector<FileInputStream> v = new Vector<FileInputStream>();
    v.add(fistream1);
    v.add(fistream2);
    SequenceInputStream sistream = new SequenceInputStream(fistream1, fistream2);

    if(!newFile.exists()){
        newFile.createNewFile();
        FileOutputStream fostream=new FileOutputStream(newFile, true);
        int temp;

        while( ( temp = sistream.read() ) != -1)
        {
            System.out.print( (char) temp ); // to print at DOS prompt
            fostream.write((byte)temp);   // to write to file
        }

        fostream.close();
        sistream.close();
        fistream1.close();
        fistream2.close();
    }
}