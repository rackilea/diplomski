int i=1;
for(String s : output){
    if(!s.isEmpty()){
        System.out.println(i++ + ". " + s.replace("\"", ""));
    }
}