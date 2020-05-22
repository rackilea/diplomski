Pattern pattern1 = Pattern.compile(
    "([^|=,]*)" +                // Group 1: The word. Zero or more characters.
    "=([^|=,]*)" +               // Group 2: The part of speech.
    ",?([^|=,]*(?:,[^|=,]*)*)" + // Group 3: The p-params
    "=([^|=,]*(?:,[^|=,]*)*)"    // Group 4: The q-params
);
Matcher matcher = pattern1.matcher("word=PS1,p1,p2,p3=q1,q2|word2=PS3,p4,p5,p6=q3");
while (matcher.find()) {
  String word = matcher.group(1);
  String partOfSpeech = matcher.group(2);
  String pParamString = matcher.group(3);
  String qParamString = matcher.group(4);
  String[] pParams = pParamString.split(",");
  String[] qParams = qParamString.split(",");
  // Do something with the above variables...
}