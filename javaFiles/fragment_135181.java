public class SO2{
public static void main(String[] args) {

 String display="";
 int z = 0;

    String size = JOptionPane.showInputDialog("Enter Your Prefered Size Of Your Array");
    int newsize = Integer.parseInt(size);

    JOptionPane.showMessageDialog(null,"You Entered "+newsize+".");
    int array[] = new int [newsize]; //Sets array

    for (int a=0; a<array.length;a++){//Puts values in array
        array[a] = Integer.parseInt(JOptionPane.showInputDialog("Enter Value For Array["+a+"]."));
    }   

    for (int a=0;a<array.length;a++){
        display=display+array[a]+"\n";
    }

    String toShow = ""; //String to build up
    for(int i = 0; i < array.length; i++){
        if(array[i] == 0){
            display = "ZERO";
        } else if(array[i] < 0){
            display = "NEGATIVE";
        } else if(array[i] > 0){
            display = "POSITIVE";
        }

        toShow += "Array element " + i + " is " + array[i] + " and it is " + display + "\n"; //Build string
    }
    JOptionPane.showMessageDialog(null,"Your numbers...\n\n"+toShow);//show
}}