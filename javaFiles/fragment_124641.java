for (Long nPosition: l)
    {
    if(nPosition == null)
        continue;

    long actualPos = nPosition+7;
    long secActualPos = actualPos+1;
    //I used 7 because I am assuming the count for the nucleotide position starts from one instead of zero. Also There are 6 other variables like familyID, individual ID....etc
    //in the data set. The "secActualPos" is to account for the second pair.

    String twoSNPphenoTindID = nList.get(actualPos).toString() + "," + nList.get(secActualPos).toString()+  "," + nList.get(5).toString() + "," + nList.get(1);

    for(Entry<String, Long> entryPos: snpLocations.entrySet())
    {
        if(entryPos.getValue().equals(nPosition))


        context.write(new Text(String.valueOf(actualPos)), new Text(twoSNPphenoTindID));
    }