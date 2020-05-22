@Override
public void reset() {
    this.filterOutRow = false;
}

@Override
public Filter.ReturnCode filterKeyValue(KeyValue v) {
    if(this.filterOutRow) {
        return ReturnCode.SEEK_NEXT_USING_HINT;
    }
    return Filter.ReturnCode.INCLUDE;
}

@Override
public boolean filterRowKey(byte[] data, int offset, int length) {
    if(startDate < getDate(data) && endDate > getDate(data)) {
        this.filterOutRow = true;
    }
    return this.filterOutRow;
}

@Override
public KeyValue getNextKeyHint(KeyValue currentKV) {
    if(getDate(currentKV) < startDate){   
         String nextKey = getId(currentKV)+","+startDate.getTime();
         return KeyValue.createFirstOnRow(Bytes.toBytes(nextKey));
    }
    if(getDate(currentKV) > endDate){   
         String nextKey = (getId(currentKV)+1)+","+startDate.getTime();
         return KeyValue.createFirstOnRow(Bytes.toBytes(nextKey));
    }
    return null;  
}

@Override
public boolean filterRow() {
    return this.filterOutRow;
}