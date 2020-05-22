try {
    fin=new FileInputStream(args[0]);
    do {
        i=fin.read();
        System.out.println((char) i);
    } while(i!=-1);
} catch(...) {
 .....
} finally {
    if(fin != null) {
        try { fin.close(); } catch(IOException e) {}
    }
}