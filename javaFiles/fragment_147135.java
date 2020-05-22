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
    }