// the arraylist way using a for each loop
int sum = 0;
for(String i : demNumbers) {
    i = i.trim(); // eliminate whitespace -> else NumberFormatException
    sum+=Integer.parseInt(i);
}

// then get the average
float average = (float) sum / (float) demNumbers.size();