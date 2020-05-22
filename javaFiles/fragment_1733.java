public class TestTree {
    private static List<Entry> entries = new ArrayList<Entry>();

    public static void main(String[] args) throws Exception {
        // simulate the DB entries
        entries.add(new Entry(1, 1, 1, "T1"));
        entries.add(new Entry(2, 2, 2, "T2"));
        entries.add(new Entry(3, 2, 1, "T2"));
        entries.add(new Entry(4, 3, 1, "T3"));
        entries.add(new Entry(5, 3, 3, "T3"));
        entries.add(new Entry(6, 4, 4, "T4"));
        entries.add(new Entry(7, 4, 2, "T4"));
        entries.add(new Entry(8, 4, 1, "T4"));

        // the root is the one entry with no parent other than self
        int root = 1;

        // map all relationships to the root
        Map<Integer, Integer> tree = new HashMap<Integer, Integer>();   // ID -> parent ID
        buildTree(tree, root);

        System.out.println(tree);

        // From this Map, it should be pretty obvious how to build the tree.
    }

    private static void buildTree(Map<Integer, Integer> tree, int parentId) {
        boolean dirty = false;
        for(Entry entry : entries) {
            if(entry.parentId == parentId && entry.teamId != parentId) {
                tree.put(entry.teamId, parentId);
                dirty = true;
            }
        }

        if(dirty) {
            // Continue building the tree from each node that was updated
            for(Integer nodeId : tree.keySet()) {
                if(tree.get(nodeId) == parentId) buildTree(tree, nodeId);
            }
        }
    }

    private static class Entry {
        int id;
        int teamId;
        int parentId;
        String teamName;

        Entry(int id, int teamId, int parentId, String teamName) {
            this.id = id;
            this.teamId = teamId;
            this.parentId = parentId;
            this.teamName = teamName;
        }
    }