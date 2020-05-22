for (int pos = 0; itr.hasNext(); pos++) {   
    String nextField = itr.next().toString();
    System.out.printf("field right now at pos:%d is :%s ; the value in the generic record is %s%n", 
        pos, nextField, genericRecord.get(pos));
    binaryObjBuilder.setField(nextField, genericRecord.get(nextField));
}