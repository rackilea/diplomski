int midIndex = (lowIndex + highIndex) / 2;
while (lowIndex <= highIndex) {    
    if ((words[midIndex]).equals(wordToFind)) { //use equals
        return midIndex;
    }
    if (wordToFind.compareTo(words[midIndex]) > 0) { //wordToFind > midIndex
        lowIndex = midIndex + 1;
    }
    if (wordToFind.compareTo(words[midIndex]) < 0) { //wordToFind < midIndex
        highIndex = midIndex - 1;
    }
// getting rid of infinite loop when the value is not in the list
    if (lowIndex==highIndex && !wordToFind.compareTo(words[midIndex]) {
        return -1;
    }
    midIndex = (lowIndex + highIndex) / 2; // notice removing lowindex++
}