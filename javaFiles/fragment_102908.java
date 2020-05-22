// inside your function
// instead of returning msgArray, create a new array and modify it.

// get the count of values that aren't null
int nonNull = 0;
for (int index = 0; index < msgArray.length; index++) {
    if (msgArray[index] != null) nonNull++;
}

// create the new array because you can't change the size of your other array
String[] newMsgArray = new String[nonNull];

// populate the array
int newIndex = 0;
for (int index = 0; index < msgArray.length; index++) {
    if (msgArray[index] != null) {
        newMsgArray[newIndex] = msgArray[index];
        newIndex++;
    }
}

return newMsgArray;