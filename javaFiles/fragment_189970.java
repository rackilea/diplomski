/*I removed check for client to be between 1-5, can be re-added.

I would add the checks for the desired spot being empty and the client 
being within 1-5 to the top of the method.

For loop iterates over the possible spaces where the client would be in range
check if client is in a space*/

if (storeArray[rowNum][colNum]==client) {
    //storeArray[rowNum][colNum]=0;
    storeArray[x][y] = client;
    //unchanged
    int count = totals.containsKey(client) ? totals.get(client) : 1;
    totals.put(client, count + 1);
}