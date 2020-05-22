@Override
public int compare(String o1, String o2) {
    String o1_prefix = o1.split(".")[0];
    String o2_prefix = o2.split(".")[0];
    if(o1_prefix.startsWith(o2_prefix)) 
        return -1;
    else if(o2_prefix.startsWith(o1_prefix)) 
        return 1;
    else return o1.compareToIgnoreCase(o2);
}