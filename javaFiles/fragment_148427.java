public class TestBean {

    // if the value parsed in the quantity column is "?" or "-", it will be replaced by null.
    @NullString(nulls = {"?", "-"})
    // if a value resolves to null, it will be converted to the String "0".
    @Parsed(defaultNullRead = "0")
    private Integer quantity

    @Trim
    @LowerCase
    @Parsed(index = 4)
    private String comments;

    // you can also explicitly give the name of a column in the file.
    @Parsed(field = "amount")
    private BigDecimal value;

    @Trim
    @LowerCase
    // values "no", "n" and "null" will be converted to false; values "yes" and "y" will be converted to true
    @BooleanString(falseStrings = {"no", "n", "null"}, trueStrings = {"yes", "y"})
    @Parsed
    private Boolean pending;
}