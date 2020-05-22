//list is an ArrayList of objects
if (list != null && list.size() > 0) {
    Map<String, ResourceTree> hm = new LinkedHashMap();
    for (int b = 0; b < list.size(); b++){
        Object[] fileObj = (Object[])list.get(b);
        if (fileObj != null) {
            String folder = (String)fileObj[0];
            String parentFolder = folder;
            String fn = (String)fileObj[1];
            String type = "";
            if (fn.equals("")) {
                parentFolder = folder.substring(0,folder.lastIndexOf("/"));
            }
            jObj1 = new JSONObject();
            jObj1.put("path",folder);
            jObj1.put("filename",fn);   

            ResourceTree rt = new ResourceTree();
            rt.setResourceObj(jObj1);
            rt.setParentPath(parentFolder);
            if (fn.equals("")) {
                hm.put(folder,rt);
            }
            ResourceTree rtParent;
            if (hm.containsKey(parentFolder)){
                rtParent = hm.get(parentFolder);
            } else {
                rtParent = new ResourceTree();
                rtParent.setParentPath(parentFolder.substring(0,parentFolder.lastIndexOf("/")));
                hm.put(parentFolder,rtParent);
            }
            rtParent.addChildrenItem(rt);
        }
    }
    List<ResourceTree> DX = new ArrayList<ResourceTree>();
        for (ResourceTree rt : hm.values()) {
            //path is the top level folder specified
            if (rt.getParentPath().equals(path.substring(0,path.lastIndexOf("/")))) {
                jList1.addAll(rt.getFileList());
            }
        }
    }
}