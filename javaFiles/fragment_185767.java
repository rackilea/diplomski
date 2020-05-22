int line = 0;
while ((sRec = in.readLine()) != null) {
        myCollection.add(reversePad(sRec, hmSizeLookup, colLength, tableName));
        a = Utility.getPositions(sRec, hmSizeLookup, colLength);
        i = i + 1;
    if (++line > 1000) {
        doTheInsert(myCollection);
        myCollection.clear();
        line = 0;
    }
}
doTheInsert(myCollection);