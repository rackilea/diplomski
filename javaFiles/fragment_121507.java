function void addLinePair(string1, string2, deltaTime) {
    // Assumes string1 and string2 have been stripped of variable text

    keyString = string1 + "|" + string2;

    hashValue = findInHashTable(keyString);

    if (hashValue == <not found>) {

      hashValue = new NumberHolder
      insertInHashtable(hashValue, keyString)

    }

    hashValue.sumtime_in_milliseconds += deltaTime
    hashValue.occurrences++
}

function void printAverages {

    for (key,value in hashTable) {
        string1 = first part of key
        string2 = second part of key
        average = (float)value.sumtime_in_milliseconds / (float)value.occurrences
        print (string1 + " --> " + string2 + ", AVERAGE = " + average + " seconds")
    }
}