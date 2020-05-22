// statement is an assignment
boolean ignored =
    Character.isDigit(...) ?
        digitArrayList.add(myDto) : charArrayList.add(myDto);

// statement is a method invocation
(Character.isDigit(...) ? digitArrayList : charArrayList)
    .add(myDto);