public String genCode() {
    String s3="";
        String s1,s2;
        if(umlClassList.size()>0)
        {
            s1=publicPrivate.get(umlClassList.size()-1);
            s2=umlClassList.get(umlClassList.size()-1);
        }
        s3=s3+s1+s2;        
    return s3+"{"+"}";

}