@Override
public void startRow(int rowNum) {
    getRowList = new ArrayList<String>();
    if (rowNum == 0) {
        count = 0;
    } else {
        count++;
    }

    if(count > SOME_LIMIT)
    throw new MyParsingTerminationException();
}