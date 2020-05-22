Boolean flag = false;    

if (a1 == 3) {
    flag = true;
    while (flag) {
        point += 1; //point = point + 1
        // Make sure that you set flag equals to false at the end of the loop though, otherwise it will infinitely loop
        // Include any other functionality needed
        flag = false;
    }
}