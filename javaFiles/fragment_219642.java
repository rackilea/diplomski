SimpleDateFormat df=(something);
final Pattern YEAR_PATTERN=Pattern.compile("\\G(?:[^y']+|'(?:[^']|'')*')*(y+)");
Matcher m=YEAR_PATTERN.matcher(df.toPattern());
int count=0;
while(m.find()) {
    String yearFormat=m.group(1);
    // Here, yearFormat contains the count-th year format
    count = count+1;
}