...
public void remove(String key) throws MapException{
    int i = this.linearProbing(key);

    (hash) entry = hashTable[i];

    if((entry !=null) && (entry == key)){
        numberOfEntries--;
 ...