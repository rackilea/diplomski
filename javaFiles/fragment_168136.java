public class DemoPartitioner implements Partitioner {

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {

        Map<String, ExecutionContext> result = new HashMap<String, ExecutionContext>();

        int range = 3;
        int fromId = 1;
        int toId = range;

        for (int i = fromId; i <= gridSize;) {
            ExecutionContext executionContext = new ExecutionContext();
            String SQL = "SELECT * FROM CUSTOMER WHERE ID BETWEEN " + fromId + " AND " + toId;
            System.out.println("SQL : " + SQL);
            executionContext.putInt("fromId", fromId);
            executionContext.putInt("toId", toId);
            executionContext.putString("SQL", SQL);
            executionContext.putString("name", "Thread" + i);
            result.put("partition" + i, executionContext);
            fromId = toId + 1;
            i = fromId;
            toId += range;
        }
        return result;
    }

}