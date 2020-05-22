String text1 = "*This* is **my** text*";
String[] words = text1.split(" ");
for(int i=0; i<words.length; i++){
    int count = words[i].length() - words[i].replace("*", "").length(); // count the number of '*'
    if(count%2 != 0){ // if it's not paired we can replace with '\*'
        words[i] = words[i].replace("*", "\\*");
    }
}
System.out.println(String.join(" ", words));

Which prints out: *This* is **my** text\*