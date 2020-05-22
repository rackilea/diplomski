int code = Integer.parseInt(JOptionPane.showInputDialog("Give a postal code"));

int requiredIndex = -1;
for (int i = 0; i < postalcode.length; i++)
    if (postalcode[i] == code)
        requiredIndex = i;
if (requiredIndex == -1){
    //there is no such postal code
} else {
    //your city is
    System.out.println(city[requiredIndex]);
}