DataInputStream dis = null;
try {
    dis = new DataInputStream(new FileInputStream("tes.t"));
    int i = -1;
    // readInt() returns -1 if end of file...
    while ((i=dis.readInt()) != -1) {
        System.out.println(i);
        // since int is read, it must have double also..
        System.out.println(dis.readDouble());
    }

} catch (EOFException e) {
    // do nothing, EOF reached

} catch (IOException e) {
    // handle it

} finally {
    if (dis != null) {
        try {
            dis.close();

        } catch (IOException e) {
             // handle it
        }
    }
}