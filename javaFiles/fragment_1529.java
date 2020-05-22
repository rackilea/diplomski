ArrayList<Integer> yourList = b.Apple();
int desiredSize=3;
int missingZeroes = desiredSize - yourList.size();
for(int addedZeroes=0; addedZeroes < missingZeroes; addedZeroes++) {
    yourList.add(0);
}
//then proceed with the above List traversal solutions.