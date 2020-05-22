StringBuffer key, value;
char c;
while ((c= in.read()) != null) {
    key = new StringBuffer();    

    if(c != " "){
        key.append(c);
    }else{
        value = new StringBuffer();
        while ((c= in.read()) == " ");//skip all the spaces
        value.append(c);//add last char found

        //find rest of value until new line
        //may want to use  System.getProperty("line.separator") or whatever the char value of new line is.
        while ((c= in.read()) != null && c != "\n") {
            value.append(c);//add last char found
        }

        map.put(key.toString(), value.toString());//map it all together
    }
}