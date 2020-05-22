int position = -1; //declare the position outside (if declared inside, it's not visible outside the loop)
for (int i = 0; i < directory.length; i++) {
     // position = i; just assign value of i inside the loop
}

//use the position after the loop
int j = position; // start at position
Entry temp = null; // temp will temporarily hold the entry at the next index
while(true) { 
    temp = directory[j + 1]; // since we need move entry at j to j+1, first we need save the entry at j+1
    directory[j + 1] = directory[j]; // entry at j to j+1
    if(temp == null) { // if the next entry is null, don't really need to move no more, so break
        break;
    }
}
// finally place new entry at index position
directory[position] = //the new Entry