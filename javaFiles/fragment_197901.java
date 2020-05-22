<t:table items="${actionBean.customerList}" var="obj" css_class="display">
  <t:col css_class="checkboxcol">
    <s:checkbox name="customerIds" value="${obj.customerId}"
                onclick="handleCheckboxRangeSelection(this, event);"/>
  </t:col>
  <t:col name="customerId" title="ID"/>
  <t:col name="firstName" title="First Name"/>
  <t:col name="lastName" title="Last Name"/>
  <t:col>
    <s:link href="/Customer.action" event="preEdit">
      Edit
      <s:param name="customer.customerId" value="${obj.customerId}"/>
      <s:param name="page" value="${actionBean.page}"/>
    </s:link>
  </t:col>
</t:table>