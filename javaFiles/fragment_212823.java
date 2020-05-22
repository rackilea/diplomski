String s1="Java is oop programming, R1|R2|R4|R5|R";
String s2="R";
String s3="R2";
String s4="R5";
String[] validTargets = new String[]{s2,s3,s4};

String alternatives = s1.split(",")[1].trim();
for(String s: alternatives.split("|")){
    for(String t: validTargets){
        if(s.matches(t)) { //you can also use equals() here..
            System.out.println("they are matched!");
        }
    }
}