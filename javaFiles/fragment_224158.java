for(Iterator<ProjectItem> iter = projectItems.iterator(); iter.hasNext(); iter.next()){
    ProjectItem item = iter.next();
    if (item.getClass() == Deliverable.class){
        result.add((Deliverable)item);
    }
}