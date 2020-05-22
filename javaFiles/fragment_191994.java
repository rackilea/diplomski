Iterator myVeryOwnIterator = meMap.keySet().iterator();
while(myVeryOwnIterator.hasNext()) {
    String key=(String)myVeryOwnIterator.next();
    String value=(String)meMap.get(key);
    Toast.makeText(ctx, "Key: "+key+" Value: "+value, Toast.LENGTH_LONG).show();
}