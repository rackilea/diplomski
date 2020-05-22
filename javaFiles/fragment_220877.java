class Key{
    private String objectName;
    private String objectType;

    //TODO write setters here

    public String getObjectName(){
        return objectName;
    }

    public String getObjectType(){
        return objectType;
    }

    public String toString(){
        return objectName + ":separator:" + objectType;
    }

    //TODO implement hashcode and equals method
}