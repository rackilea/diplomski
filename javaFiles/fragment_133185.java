public static void main(String[] args){
            RandomAccessFile raf = null;
    try {

        String array[][] = new String[2][3];
        raf=new RandomAccessFile("D:\\employee.txt","rw");
        for (int i = 0; i < array.length; i++) {
            String inputName=JOptionPane.showInputDialog("Please Insert First Name");
            array[i][0]=inputName;
            String inputLName=JOptionPane.showInputDialog("Please Insert Last Name");
            array[i][1]=inputLName;
            String inputMeliiC=JOptionPane.showInputDialog("Please Insert Melii Code");
            array[i][2]=inputMeliiC;

            raf.writeChars(array[i][0]);
            raf.writeChar(':');
            raf.writeChars(array[i][1]) ;
            raf.writeChar(':');
            raf.writeChars(array[i][2]);
            raf.writeChars("\n");

        }
        raf.seek(0);

        String str = raf.readLine();
        while(str != null ){
            System.out.println(str);
            String arr[] = str.split(":");
            System.out.println(Arrays.asList(arr));
            str = raf.readLine();
        }

        raf.close();
    } catch (FileNotFoundException e) {
                try {
                    raf.close();
                } catch (IOException ex) {
                    Logger.getLogger(Ideone.class.getName()).log(Level.SEVERE, null, ex);
                }
        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    } catch (IOException e) {
                try {
                    raf.close();
                } catch (IOException ex) {
                    Logger.getLogger(Ideone.class.getName()).log(Level.SEVERE, null, ex);
                }
        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }

}