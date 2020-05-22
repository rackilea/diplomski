Map<String, String> abbrev = new HashMap<String, String>();

String str="tran. all of the wo. f. me";
String[] words = str.split(" ");
String result = "";

for (String word : words) {
    if(abbrev.get(word) != null){
        result= result+ abbrev.get(word);
    }else{
        result= result+ word;
    }
    result= result+ " ";
}