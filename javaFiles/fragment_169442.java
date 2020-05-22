boolean containsHost(String list, String host) {
    boolean result = false;
    int i = -1;
    while((i = list.indexOf(host, i + 1)) >= 0) { // while there is next match
        if ((i == 0 || list.charAt(i - 1) == ',') // beginning of the list or has a comma right before it
                && (i == (list.length() - host.length()) // end of the list 
                || list.charAt(i + host.length()) == ',')) { // or has a comma right after it
            result = true;
            break;
        }
    }
    return result;
}