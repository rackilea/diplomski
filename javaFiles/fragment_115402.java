private void tester(){
    if(number<liste.length) {
        number++;
    }
    test.setText(liste[number]);  //if number is greater than liste.length this would lead to an ArrayIndexOutOfBoundsException!
}