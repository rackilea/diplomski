String value =Integer.toString();
String tempVal;
int index = 0;
while (index<value.size()){
    if (index+3>value.size(){
       tempVal = value.substring(index);
       //do my operation on Integer.parseInt(tempVal)
       break;
    }
    tempVal = value.substring(index,index+3);
    //do my operation on Integer.parseInt(tempVal)
    index +=3;
}