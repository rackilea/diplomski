List<List<Integer>> myInput = ...

for(int i=0; i<myInput.size(); i++){
     for (int j=0; j<myInput.get(i).size(); j++){
        if (j == 0 && i > 0){
           continue;
        }
        List<Integer> result = new ArrayList<Integer>(myInput.size());
        for(int k=0; k<myInput.size(); k++){
            if (k == i){
               result.add(myInput.get(k).get(j));
            }else{
               result.add(myInput.get(k).get(0));
            }
        }
        System.out.println(result);
     }
}