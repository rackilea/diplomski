int index =  str.indexOf("/*");

while(index != -1) {
    str = str.substring(0, index) + str.substring(str.indexOf("*/")+2);
    index =  str.indexOf("/*");
}