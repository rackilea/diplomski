final Object[][] result = new Object[map.size()][2];

final Iterator<?> iter = map.entrySet().iterator();

int ii = 0;
while(iter.hasNext()){
    final Map.Entry<?, ?> mapping = (Map.Entry<?, ?>) iter.next();

    result[ii][0] = mapping.getKey();
    result[ii][1] = mapping.getValue();

    ii++;
}