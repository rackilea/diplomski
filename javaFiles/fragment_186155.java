public void run() {
    if (pout != null){
        parseXmlFile(); 
        parseDocument();
        writeToStream();
    }
    if (pin != null){
        readStream();
        sortByAge();
        printData();
    }
 }

public void writeToStream(){
    try{
        out = new ObjectOutputStream(pout);
        out.writeObject(myEmpls);
        out.flush();
        out.close();
        pout.flush();
        pout.close();
    }catch (Exception e) {
        System.out.println("ErrorWS:" + e);
    }
}

public void readStream(){
    try{
        in = new ObjectInputStream(pin);
        myEmpls = (List<Employee>) in.readObject();
        in.close();
        pin.close();
    }catch (Exception e) {
        System.out.println("ErrorRS:" + e);
    }
}