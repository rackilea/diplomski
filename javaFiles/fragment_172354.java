int year = 2009;
int timeKey = -1;

for (int array[] : Time) {
    if (array[1] == year) {
        timeKey = array[0]; 
        break;
    }
}

int sum = 0;

for (int array[] : FactTable) {
    if (array[3] == timeKey) {
        sum += array[4]; 
    }
}

System.out.println(sum);