String[] fruits = {"jan","feb","mar","apr","may","jun","jul","aug","sept","oct"};
public String getStr(int pos) {
    if( pos < fruits.length && pos > -1){
        return fruits[pos];
    }
    return null;
}