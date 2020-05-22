needle = "abbc"
text = "abbcbbabbcaabbca"

needleSize = needle.length()
//Map of needle character counts
targetMap = [a->1, b->2, c->1]

matchedLength = 0
curMap = [a->0, b->0, c->0]
//Initial map initialization
for (int i=0;i<needle.length();i++) {
    if (curMap.contains(haystack[i])) {
        matchedLength++
        curMap[haystack[i]]++
    }
}

if (matchedLength == needleSize) {
    System.out.println("Match found at: 0");
}

//Search itself
for (int i=0;i<haystack.length()-needle.length();i++) {
    int targetValue1 = targetMap[haystack[i]]; //Reading from hashmap, O(1)
    int curValue1 = curMap[haystack[i]]; //Another read
    //If we are removing beneficial character
    if (targetValue1 > 0 && curValue1 > 0 && curValue1 <= targetValue1) {       
        matchedLength--;
    }
    curMap[haystack[i]] = curValue1 + 1; //Write to hashmap, O(1)


    int targetValue2 = targetMap[haystack[i+needle.length()]] //Read
    int curValue2 = curMap[haystack[i+needle.length()]] //Read
    //We are adding a beneficial character
    if (targetValue2 > 0 && curValue2 < targetValue2) { //If we don't need this letter at all, the amount of matched letters decreases
        matchedLength++;
    }
    curMap[haystack[i+needle.length()]] = curValue2 + 1; //Write

    if (matchedLength == needleSize) {
        System.out.println("Match found at: "+(i+1));
    }
}

//Basically with 4 reads and 2 writes which are 
//independent of the size of the needle,
//we get to the maximal possible performance: O(n)