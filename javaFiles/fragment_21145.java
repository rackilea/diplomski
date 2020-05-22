public String spaceRequirement(){
     int s = 0;
     int t = 0;
     int k = 0;
     for (int i = 0; i < animal_list.size(); i++){
         if (animal_list.get(i) instanceof Giraffe){
                s += animal_list.get(i).getSpaceRequired();
         }
         System.out.println(s);
         if (animal_list.get(i) instanceof Penguin){
                t += animal_list.get(i).getSpaceRequired();
         }
         if (animal_list.get(i) instanceof Tiger){
                k += animal_list.get(i).getSpaceRequired();
         }

     }
     return "Total tree height needed: " + t + "\nTotal water volume needed: " + s + "\nTotal grass area needed: " + k;
 }