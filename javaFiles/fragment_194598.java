String text1=jt1.getText();
String text2=jt2.getText();
String text3=jt3.getText();
String text4=jt4.getText();
String text5=jt5.getText();

if (text1 != null && !text1.trim().isEmpty() &&
    text2 != null && !text2.trim().isEmpty() &&
    text3 != null && !text3.trim().isEmpty() &&
    text4 != null && !text4.trim().isEmpty() &&
    text5 != null && !text5.trim().isEmpty()) {
     //... Do insert
 } else {
     // Deal with the fact that one or more of the values are invalid
 }