public static class TestStyle extends ToStringStyle{
    TestStyle() {//constructor is copied from ToStringStyle.MULTI_LINE_STYLE
        super();
        this.setContentStart("[");
        this.setFieldSeparator(SystemUtils.LINE_SEPARATOR + "  ");
        this.setFieldSeparatorAtStart(true);
        this.setContentEnd(SystemUtils.LINE_SEPARATOR + "]");
    }

//override this to do checking of null, so only non-nulls are printed out in toString
@Override
public void append(StringBuffer buffer, String fieldName, Object value, Boolean fullDetail) {
    if (value != null) {
        super.append(buffer, fieldName, value, fullDetail);
    } 
}