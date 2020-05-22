int i = 0;

public String recursiveAppend(String tst) {
    if(i >= x) {
        i = 0;
        return tst;
    }
    else return recursiveAppend(tst + y);
}