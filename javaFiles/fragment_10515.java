public void reader(){
    try{
    FileInputStream fis = new FileInputStream("C:\\file.dat");
    ObjectInputStream ois = new ObjectInputStream(fis);
    int j = model.getRowCount();
    for(int i = 0; i<j;i++){
        Object a = model.getValueAt(i,1);
        Object b = ois.read((byte[]) a);
        if(a.equals(b)){
            doner();
            fis.close();
        }
        else{
            JOptionPane.showMessageDialog(null,"You do not have "+a.toString()+" in your inventory. Add it to your inventory first.","Item Not Found", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    }catch (IOException e){
        JOptionPane.showMessageDialog(null,"File file.dat not found in C:\\. Make a empty file in the folder and save it with busy.dat","File not found", JOptionPane.ERROR_MESSAGE);
    }
}