public String genCode() {
    String s3="";
    for (int index = 0; index < umlClassList.size(); index++) {
        String s1,s2;
        s1=publicPrivate.get(index);
        s2=umlClassList.get(index);
        s3=s3+s1+s2;        
    }
    return s3+"{"+"}";

}