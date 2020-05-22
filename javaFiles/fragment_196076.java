public class GameLoader {

    private List<BlockObject> blocksArray = new ArrayList<BlockObject>();

    public Object getNewBlock(String blockClassName) throws     ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class blockClass = Class.forName(blockClassName);
        return blockClass.newInstance();

    }

    public void addNewBlockType(String typeName) throws     ClassNotFoundException, InstantiationException, IllegalAccessException {

        BlockObject castedType = (BlockObject)getNewBlock(typeName); 
        blocksArray.add(castedType);
    }
}