class theClass{
    String type;
    String scope;

    public theClass(String string1, String string2)
    {
        type = string1; scope = string2;
    }

    @Override
    public String toString(){
      return type+" "+scope;
    }

}