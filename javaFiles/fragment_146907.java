for (int i = 0; i < args.length(); i++){
    char c = args.charAt(i);        
    s += lookup.get(c+"");
    //                 ↑ ugly but converts char to String
    s += " ";
}