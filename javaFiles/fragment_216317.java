public static void main(String[] args){
  String sourcestring = "<description>&lt;a href='http://testlink.html' alt='some text'&gt;&lt;img border='0' src='http://s2.glbimg.com/zzag70iNYX-QK24sUp0YXQmmXhx7yb8j2Sq2YK7tvX3A6vCwEUOFnFTBONQFT-
ni/s.glbimg.com/es/ge/f/original/2012/04/25/image.jpg' 
alt='some' title='text' /&gt;&lt;/a&gt;&lt;br /&gt;some text; some text</description>";
  Pattern re = Pattern.compile("(?<=href='|alt=')[^']*|(?<=href=\"|alt=\")[^\"]*");
  Matcher m = re.matcher(sourcestring);
  int mIdx = 0;
    while (m.find()){
      for( int groupIdx = 0; groupIdx < m.groupCount()+1; groupIdx++ ){
        System.out.println( "[" + mIdx + "][" + groupIdx + "] = " + m.group(groupIdx));
      }
      mIdx++;
    }
  }