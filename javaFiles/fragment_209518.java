Object[] results = api.getProjects();
    for(Object tp : results){    
       String name = ((TestProject)tp).getName() ;
       String id = ((TestProject)tp).getId() ;
       System.out.println(name);
       System.out.println(id);
     }