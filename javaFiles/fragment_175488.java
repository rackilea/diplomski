import org.apache.ibatis.annotations.Param;

List<Map<String, Object>> nagaFindVariable(
   @Param("variableName") String variableName, 
   @Param("variableValue") String variableValue
);