final ExpressionParser parser = new SpelExpressionParser();
Expression expression = parser.parseExpression("expressionUtil.subtractDates(fromDate, toDate)");
Wrapper wrapper = new Wrapper();
wrapper.setFromDate(new Date(System.currentTimeMillis()));
wrapper.setToDate(new Date(System.currentTimeMillis() + 1000));
Long value = expression.getValue(wrapper, Long.class);
System.out.println(value);

...

public static class Wrapper {

    private final ExpressionUtil expressionUtil = new ExpressionUtil();

    private Date fromDate;

    private Date toDate;

    public Date getFromDate() {
        return this.fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return this.toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public ExpressionUtil getExpressionUtil() {
        return this.expressionUtil;
    }

}

public static class ExpressionUtil {

    public long subtractDates(Date from, Date to) {
        return to.getTime() - from.getTime();
    }

}