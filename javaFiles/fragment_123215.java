HashMap map = new HashMap();
Object[][] arr = new Object[map.size()][2];
Set entries = map.entrySet();
Iterator entriesIterator = entries.iterator();

int i = 0;
while(entriesIterator.hasNext()){

    Map.Entry mapping = (Map.Entry) entriesIterator.next();

    arr[i][0] = mapping.getKey();
    arr[i][1] = mapping.getValue();

    i++;
}