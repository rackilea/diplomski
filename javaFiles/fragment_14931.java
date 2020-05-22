int count = 0;
Matcher m = p.matcher(s);
while(m.find()) {
    count++;
}
return count;