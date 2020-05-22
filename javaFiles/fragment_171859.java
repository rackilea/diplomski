public static GroupClass findTheClass(Set<GroupClass> group, int id){
    for(GroupClass obj: group){
        if(obj.getIdNumber == id) return obj;
    }
    return null;
}