@Override
public int compare(String o1, String o2) {      
    if(o2.equals("XX")) {
        return o1.equals("XX") ? 0 : 1;
    } else if (o1.equals("XX")) {
        return -1;
    }
    return o1.compareTo(o2);
}