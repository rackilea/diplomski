Collection<RepositoryInfo> infos = localManager.getAllRepositoryInfos();
 for (RepositoryInfo info: infos) { 
       System.out.println("id: " + info.getId());
       System.out.println("description: " + info.getDescription());
       System.out.println("location: " + info.getLocation());
 }