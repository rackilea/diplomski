// run with --add-opens java.base/java.util=ALL-UNNAMED

static Class<?> classNode;
static Class<?> classTreeNode;
static Field fieldNodeNext;
static Field fieldHashMapTable;

static void init() throws ReflectiveOperationException {
    classNode = Class.forName("java.util.HashMap$Node");
    classTreeNode = Class.forName("java.util.HashMap$TreeNode");
    fieldNodeNext = classNode.getDeclaredField("next");
    fieldNodeNext.setAccessible(true);
    fieldHashMapTable = HashMap.class.getDeclaredField("table");
    fieldHashMapTable.setAccessible(true);
}

static void dumpMap(HashMap<?, ?> map) throws ReflectiveOperationException {
    Object[] table = (Object[])fieldHashMapTable.get(map);
    System.out.printf("map size = %d, table length = %d%n", map.size(), table.length);
    for (int i = 0; i < table.length; i++) {
        Object node = table[i];
        if (node == null)
            continue;
        System.out.printf("table[%d] = %s", i,
            classTreeNode.isInstance(node) ? "TreeNode" : "BasicNode");

        for (; node != null; node = fieldNodeNext.get(node))
            System.out.print(" " + node);
        System.out.println();
    }
}