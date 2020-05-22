String tempList; //Create string variable named tempList
int lineCount = 0; //Create integer variable named lineCount
String sep = ": Temp "; //Create string variable named sep (short for separation) and set it equal to the literal string ":"
String space = " "; //Create string variable named space and set it equal to an actual space between texts

String maxValueYear = "";
String minValueYear = "";
double maxValue = 0;
double minValue = Double.MAX_VALUE;
System.out.println("The following is the provided information from the file input. ");
while ((tempList = kb.readLine()) !=null) { //while loop stating that as long as the text file still has values to read (is not null), continue to execute

    String year = tempList.substring(0, tempList.indexOf(space));
    double temp = Double.valueOf(tempList.substring(tempList.indexOf(space), tempList.length()));

    if (temp > maxValue) {
        maxValue = temp;
        maxValueYear = year;
    }
    if (temp < minValue) {
        minValue = temp;
        minValueYear = year;
    }
    System.out.println("Line " + lineCount++ + ": Year " + tempList.replace(space, sep)); //Prints out the line number (lineCount++), the info from the temps.txt file with a ":" between the year and the number (tempList.replace (space,sep)

}

System.out.println("The minimum temp occured in year " + minValueYear + " and was " + minValue);
System.out.println("The maximum temp occured in year " + maxValueYear + " and was " + maxValue);