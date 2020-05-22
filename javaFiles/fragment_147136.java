String highestName = "";
double highestValue = 0;
for (int i = 0; i < classSize; i++) {
    if(scoreArray[i] > highestValue) {
        highestName = nameArray[i];
        highestValue = scoreArray[i];
    }
}
System.out.println(highestName + " has the highest grade.")