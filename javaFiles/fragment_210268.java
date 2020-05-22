public void method2(){
    try {
        FileOutputStream fileOut = new FileOutputStream("card.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        method1();
        out.writeObject(driver); 
        out.close();
        fileOut.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}