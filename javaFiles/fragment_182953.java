....
regex = "(inet addr:)([0-9.]+)";
.....

if(matcher.find()){
    ipAddress = matcher.group(2);
}