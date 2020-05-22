public void saveObject(){
        [try catch stuff not shown]
        instance.setObject(new Object());
        FileOutputStream fos = new FileOutputStream(new File("object.xml"));
    XMLEncoder xmle = new XMLEncoder(fos);
    xmle.writeObject(instance);
    xmle.close();
}