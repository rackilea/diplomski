//firstList = "1","2","3","4";
<s:iterator value="firstList" var="parent">
  <s:iterator value="getSecondList(#parent)">
    //Do Something
  </s:iterator>
<s:iterator>