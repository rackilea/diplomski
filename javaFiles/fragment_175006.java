String userInput = "dog loves fox.";

String types[] = {"The quick brown (?<animal>.*?) jumped over the lazy (?<target>.*?).",
                  "(?<target>.*?) loves (?<animal>.*?).",
                  "(?<animal>.*?) became friends with (?<target>.*?)"};

Matcher m;

for(int i=0; i<types.length(); i++;){
    if(userInput.matches(types[i]){
        m = Pattern.compile(types[i]).matcher(userInput);
        break;
    }
}

m.find();

String animal = m.group("animal");
String target = m.group("target");