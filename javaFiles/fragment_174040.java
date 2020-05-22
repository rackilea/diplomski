<!-- This will work, EL does support String: -->
<h:commandButton ... action="#{backingBean.test('SUBMITTED')}" />    

// backingBean:
public void test(String queryScopeString) {
    QueryScope queryScope = QueryScope.valueOf(queryScopeString);
    // your impl
}