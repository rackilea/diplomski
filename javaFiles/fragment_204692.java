String data = "poniedziałek28.08";
 String[] dni = {"poniedziałek","wtorek","środa","czwartek","piątek","sobota","niedziela"};
 String dataZseparatorem = "";

for(int i = 0; i < dni.length; i++){
 if(data.startsWith(dni[i]) == true){
         dataZseparatorem = data.substring(dni[i].length());
     }
 }
System.out.println(dataZseparatorem);
 String dzien[] = dataZseparatorem.split(Pattern.quote("."));

 System.out.println(dzien[0] + " " + dzien[1]);