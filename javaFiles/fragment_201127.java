public class MyCodegen extends AbstractJavaCodegen{ \\or 
    [...]
    @Override
    public Map<String, Object> postProcessOperations(Map<String, Object> objs) {
        super.postProcessOperations(objs);
        Map<String, Object> operations = (Map<String, Object>) objs.get("operations");
        if (operations != null) {
            List<CodegenOperation> ops = (List<CodegenOperation>) operations.get("operation");
            for (CodegenOperation operation : ops) {
                if(operation.httpMethod.equals("GET"){
                    operation.operationId = "get_" + operation.operationId;
                }[...]
            }
        }
        return objs;
    }
}