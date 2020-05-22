for(ObjectToBeSearched bean:objectList){
    Field field = bean.getClass().getDeclaredField("searchKey");
    String searchKeyVal=field.get(bean);
    if(criteria.equals(searchKeyVal)){
    System.out.println("Object found!!!");
    }
    }