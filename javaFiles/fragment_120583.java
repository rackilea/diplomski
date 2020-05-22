class ThirdParty{

    int field1;
    int field2;
}

class Transfer implements Serializable{

    int field1;
    int field2;

    /* Constructor takes the third party object as 
       an argument for copying the field values.
       For private fields without getters 
       use reflection to get the values */
    Transfer (ThirdParty orig){
       this.field1=orig.field1;
       this.field2=orig.field2;
    }

    ThirdParty getAsThirdParty(){
        ThirdParty copy=new ThirdParty();
        copy.field1=this.field1;
        copy.field2=this.field2;
        return copy;
    }

    /* override these methods for custom serialization */
    void writeObject(OutputStream sink);
    void readObject(InputStream src);
}