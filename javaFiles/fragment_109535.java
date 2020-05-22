public class DynamicColumn extends AbstractColumn {
    ...

    @Override
    public String getTextForExpression() {
        return getColumnProperty().getProperty();
    }
    @Override
    public String getValueClassNameForExpression() {
        return getColumnProperty().getValueClassName();
    }
}