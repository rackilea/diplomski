for(Map<String, Object> child : List){
    for(String key : child.keySet()){
                if(child.get(key)==null)
                    child.remove(key);
    }
}