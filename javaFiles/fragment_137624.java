String total = "";
BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));;
while (total.length() < 160 && total.endsWith("!!") == false){ // if the string is less then 160 chars long and not ending with !!
    int c = in.read(); // read next char in buffer
    if(c == -1) break; // in.read() return -1 if the end of the buffer was reached
    total += (char)c; // add char to string
}
in.close();