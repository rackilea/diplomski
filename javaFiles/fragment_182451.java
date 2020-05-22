//create hashmap
private HashMap<String,Integer> resources;

//fill hash map with resources
resources.put("FIRST",R.drawable.example_img_1);
resources.put("SECOND",R.drawable.example_img_2);

//simple method to access resources
public Integer getResourceId(String key){
    if(resources.containsKey(key))
        return resources.get(key);
    return R.drawable.default_image;
}