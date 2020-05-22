String s = Long.toBinaryString(432345579867562500l);
int i = s.indexOf("11010010");
String subStr = null;
if(i>0){
    subStr = s.substring(i+8,i+8+16);
}
System.out.println(subStr);

//0001101110110001      //output