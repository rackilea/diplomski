String[] s1 = String1.split(" ");
String[] s2 = String2.split(" ");

for(String s : s1){
    for(String ss : s2){
        if(ss.equals(s)){
            //do something
        }
    }
}