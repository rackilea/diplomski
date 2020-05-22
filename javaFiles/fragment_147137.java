String[] highestNames = new String[classSize];
int numHighest = 0;
double highestValue = 0;
for (int i = 0; i < classSize; i++) {
    if(scoreArray[i] > highestValue) {
        highestNames[0] = nameArray[i];
        numHighest = 1;
        highestValue = scoreArray[i];
    } else if(scoreArray[i] > highestValue) {
        highestNames[numHighest] = nameArray[i];
        numHighest = numHighest + 1;
    }
}

System.out.println("The following student(s) has/have the highest grade: ")
boolean first2 = true;
for (int i = 0; i < numHighest; i++)
    {
        if(!first2) {
            System.out.println(", ");
            first2 = false;
        }
        System.out.print(highestNames[i])
        }
    }