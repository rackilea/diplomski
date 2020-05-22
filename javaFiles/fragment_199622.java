Integer n = null;
try {
    n = Integer.parseInt(reader.readLine());
}
catch(NumberFormatException e){
    log.error('Can't parse string');
}
if (n == null) {
    n = 0;
}