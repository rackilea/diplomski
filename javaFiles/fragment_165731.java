for (int i = 0; i < 8; i++) { //line number your on
    for(int k = 0; k<i;k++)//keeps track of number of spaces to use, line number minus 1 spaces printed
    {
    System.out.print(" ");
    }
for (int j = 8; j >i; j--) {//prints out 8 * and reduced by 1*line number
System.out.print("*"); 
}
System.out.println();//prints new line and initiates new line by i++
}