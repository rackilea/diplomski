while (true) { // for(;;) if you prefer
    String s = in.readLine();
    //if (s == null || s.length() == 0) break; // stop on empty lines and end of stream
    if (s == null) break; // stop at end of stream only
    line[i++] = s;
}