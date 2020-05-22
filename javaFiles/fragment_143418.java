String[] tab = {"Jean", "Maximilien", "Brigitte", "Sonia", "Jean-Pierre", "Sandra"};

for(String elt : tab){
    if(elt.length() > 6){
        list1.add(elt);
    }else{
        list2.add(elt);  
    }
}