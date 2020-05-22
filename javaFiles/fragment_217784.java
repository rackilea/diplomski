public Appender append(String str, int n) {
    while(n > 0){
        sb.append(str);
        n--;
    }
    return this;
}