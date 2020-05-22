public class SerializeMe implements Serializable {
    private Integer id;
    private String value;
    private BigMatrix bigMatrix = BigMatrixFactory.fromValues(id, value).build();

    public BigDecimal doExpensiveOperation() {
        BigDecimal result = BigDecimal.ZERO;
        for(BigDecimal value : bigMatrix.getAllValuesFromAllMatrixFields() {
            matrixMultiply(result, value);
        }
        return result;
    }
}