public String getAddress(String name) {
    String address = "";
    boolean nameFound=false;
    for(String str:lines)
    {
        if(!nameFound && str.equals(name))
            nameFound=true;
        else if(nameFound && str.isEmpty())
            break;
        else if(nameFound && !str.isEmpty())
            address+=str;
    }
    return address;
}