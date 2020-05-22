Pattern p=Pattern.compile("'''.*?'''|'.*?'");
Matcher m=p.matcher(value);
int normalPos=0, length=value.length();
while(normalPos<length && m.find())
{
  int quotePos=m.start(), quoteEnd=m.end();
  if(normalPos<quotePos) processNormally(value.substring(normalPos, quotePos));
  final boolean tripleQuote=m.end()-m.start()>=6 && value.charAt(quotePos+1)=='\'';
  final int skip=tripleQuote? 3: 1;
  processQuoted(value.substring(quotePos+skip, quoteEnd-skip));
  normalPos=quoteEnd;
}
if(normalPos<length) processNormally(value.substring(normalPos));