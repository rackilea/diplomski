private void saveNode(Node n){
    FileOutputStream fout = new FileOutputStream("file.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fout);
    oos.writeObject(n);
    oos.close();
}

private Node readNode(){
   FileInputStream fin = new FileInputStream("file.txt");
   ObjectInputStream ois = new ObjectInputStream(fin);
   Node n = (Node)ois.readObject();
   ois.close();
   return n;
}