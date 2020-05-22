//remove this line
//Object[] values = new Object[properties.length];

int i = 0;
while (collection.next()) {
    //put it here
    Object[] values = new Object[properties.length];
    for (int x = 0; x < properties.length; x++) {
        values[x] = collection.getString(properties[x]);
    }
    map.put(i++, values);
}