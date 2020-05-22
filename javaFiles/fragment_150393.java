public class ResourceTree {
    private String parentPath;
    private List<ResourceTree> childrenItems;
    private JSONObject jObj1;

    public ResourceTree() {
        this.parentPath = "";
        this.childrenItems = new ArrayList<ResourceTree>();
    }

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public JSONObject getResourceObj() {
        return jObj1;
    }

    public void setResourceObj(JSONObject jObj1) {
        this.jObj1 = jObj1;
    }

    public List<ResourceTree> getChildrenItems() {
        return childrenItems;
    }

    public void setChildrenItems(List<ResourceTree> childrenItems) {
        this.childrenItems = childrenItems;
    }

    public void addChildrenItem(ResourceTree childrenItem){
        if(!this.childrenItems.contains(childrenItem))
            this.childrenItems.add(childrenItem);
    }

    public JSONArray getFileList() {
        JSONArray jList1 = new JSONArray();
        JSONObject jObj2 = new JSONObject();
        List rtChilds = getChildrenItems();
        for (int i = 0; i < rtChilds.size(); i++) {
            ResourceTree rt = (ResourceTree)rtChilds.get(i);
            jObj2 = rt.getResourceObj();
            if (rt.getChildrenItems().size() > 0) {
                jObj2.put("files",rt.getFileList());
            }
            jList1.add(jObj2);
        }
        return jList1;
    }
}