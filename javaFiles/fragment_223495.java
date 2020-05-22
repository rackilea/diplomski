List<String> getNavItems(List<GroupNavigationItemSRO> items){
    List<String> results = new ArrayList();
    System.out.println("PRINT");
    if(items != null && !items.isEmpty()){
        for(GroupNavigationItemSRO item : items) {
            results.add(item.getUrl());
            System.out.println(item.getUrl());
            // g.add(item.getUrl());
            System.out.println("PRINT");
            results.addAll(getNavItems(item.getChildren()));
           }
        }
    }
    return results;
}