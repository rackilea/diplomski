int exists = s.indexOf('<'); //Or any char
int close = s.lastIndexOf('>'); //Or other pair of char

if (exists != -1 && close != -1) { //Could be modified depending on the situation
    //Perform logic
}