public List<Integer> getList(int x,int n){
        int lower = x-n ; 
        int upper = x + n ; 
        List<Integer> ls= new ArrayList<Integer>() ; 
        for(int i = lower ; i<=upper ; i++){
            ls.add(i) ; 
        }

   return ls ; 
}