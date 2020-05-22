List<Map> yourList=new ArrayList<Map>();
   List<WorkEntry> list=q.getResultList();
   for(WorkEntry we:list){
       BeanMap map=new BeanMap(we);
       yourList.add(map);
   }