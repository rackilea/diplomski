String[] highestNames = new String[classSize];
int numHighest = 0;
double highestValue = 0;
System.out.println("The following students are below average: ")
boolean first = true;
for (int i = 0; i < classSize; i++)
    {
        if(scoreArray[i] < average) {
            if(!first) {
                System.out.println(", ");
                first = false;
            }
            System.out.print(nameArray[i])
        }
        if(scoreArray[i] > highestValue) {
            highestNames[0] = nameArray[i];
            numHighest = 1;
            highestValue = scoreArray[i];
        } else if(scoreArray[i] > highestValue) {
            highestNames[numHighest] = nameArray[i];
            numHighest = numHighest + 1;
        }
    }