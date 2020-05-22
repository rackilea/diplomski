public class Test { 

    public static void main(String[] args) 
    {
        // hierarchical data in a flattened list
        String[][] data = {
                {"Toyota", "Gas", "Compact", "Corolla"},
                {"Toyota", "Gas", "Compact", "Camry"},
                {"Toyota", "Hybrid", "Compact", "Prius"},
                {"Honda", "Gas", "Compact", "Civic"}
        };

        TreeManager treeManager = new TreeManager();

        for(String[] row : data)
        {
            // build the path to our items in the tree
            List<String> path = new ArrayList<String>();
            for(String item : row)
            {
                // add this item to our path
                path.add(item);
                // will add it unless an Item with this name already exists at this path
                treeManager.addData(treeManager, path);
            }
        }

        treeManager.getData(data[0]).putValue("MPG", 38);
        treeManager.getData(data[1]).putValue("MPG", 28);

        Gson gson = new Gson();

        System.out.println(gson.toJson(treeManager));
    }

    /**
     * This base class provides the hierarchical property of
     * an object that contains a Map of child objects of the same type.
     * It also has a field - Name
     *
     */
    public static abstract class TreeItem implements Iterable<TreeItem>{

        private Map<String, TreeItem> children;     
        private String name;

        public TreeItem() {
            children = new HashMap<String, TreeItem>();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void addChild(String key, TreeItem data) 
        {           
            children.put(key, data);
        }

        public TreeItem getChild(String key) 
        {           
            return children.get(key);
        }

        public boolean hasChild(String key) 
        {           
            return children.containsKey(key);
        }

        @Override
        public Iterator<TreeItem> iterator() {          
            return children.values().iterator();
        }           
    }

    /**
     * This is our special case, root node. It is a TreeItem in itself
     * but contains methods for building and retrieving items from our tree
     *
     */
    public static class TreeManager extends TreeItem
    {       
        /**
         * Will add an Item to the tree at the specified path with the value
         * equal to the last item in the path, unless that Item already exists 
         */
        public void addData(List<String> path)
        {
            addData(this, path);
        }

        private void addData(TreeItem parent, List<String> path)
        {
            // if we're at the end of the path - create a node
            String data = path.get(0);
            if(path.size() == 1)
            {
                // unless there is already a node with this name
                if(!parent.hasChild(data))
                {
                    Group group = new Group();
                    group.setName(data);
                    parent.addChild(data, group);
                }
            }
            else
            {
                // pass the tail of this path down to the next level in the hierarchy
                addData(parent.getChild(data), path.subList(1, path.size()));
            }
        }

        public Group getData(String[] path)
        {
            return (Group) getData(this, Arrays.asList(path));
        }

        public Group getData(List<String> path)
        {
            return (Group) getData(this, path);
        }

        private TreeItem getData(TreeItem parent, List<String> path)
        {
            if(parent == null || path.size() == 0)
            {
                throw new IllegalArgumentException("Invalid path specified in getData, remainder: " 
                        + Arrays.toString(path.toArray()));
            }
            String data = path.get(0);
            if(path.size() == 1)
            {
                return parent.getChild(data);
            }
            else
            {
                // pass the tail of this path down to the next level in the hierarchy
                return getData(parent.getChild(data), path.subList(1, path.size()));
            }
        }
    }

    public static class Group extends TreeItem {

        private Map<String, Object> properties;

        public Object getValue(Object key) {
            return properties.get(key);
        }

        public Object putValue(String key, Object value) {
            return properties.put(key, value);
        }

        public Group () {
            super();
            properties = new HashMap<String, Object>();
        }       
    }
}