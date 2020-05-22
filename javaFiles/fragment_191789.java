//Lets say your String array has this content after 
//user fills it: {"test1", "", "test2", "test4", "", null}

for (int i = 0; i < tab.length; i++) {
     if(!(tab[i] == null)){
         System.out.println(tab[i]);
     }      
}