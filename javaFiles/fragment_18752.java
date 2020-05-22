JLabel label1 = new JLabel l("5");
JLabel label2 = new JLabel l("");

int i = Integer.parseInt(label1.getText()); // takes the string from label1 and transforms it to an integer using the parseInt() method.
// i now has the value 5

i = i*5; // an example of some calculation you mentioned you wanted to do

label2.setText(i +""); // transforms the integer value to string and sets it into label2