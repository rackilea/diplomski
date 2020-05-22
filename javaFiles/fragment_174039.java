<!-- This won't work, EL doesn't support Enum: -->
<h:commandButton ... action="#{backingBean.test(QueryScope.SUBMITTED)}" />

// backingBean:
public void test(QueryScope queryScope) {
    // your impl
}