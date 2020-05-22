public void actionPerformed(ActionEvent pushButton){
    try {
        int labelLength = label.length();
        int index = Integer.parseInt(label.substring(labelLength - 1, labelLength));
        Silo silo = doSomethingToGetLiqPlantSimInstance().getSilo(index);
        silo.state = "full" //Note that it is good practice to use private fields and public getters and setters
    } catch (NoSuchFieldException e) {
    } catch (SecurityException e) {
    }
    System.out.println(label.split("")[2]);
}