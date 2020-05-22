<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>

<script>
var error="";
function showDialog(msg){
        alert(msg);
}
</script>
</head>

<body>

<s:form action="/performAnalysis" >

    <s:textfield name="firstName" />
    <s:textfield name="lastName" />
    <s:submit value="Submit" />

</s:form>
   <s:if test="hasActionErrors()">
      <s:iterator var="error" value="actionErrors"> //display all actionErrors similar to <s:actionerror />
        <script>
              error += "<s:property value='#error' />";
            </script> 
      </s:iterator>
      <script>
        showDialog(error);
      </script>
   </s:if>
</body>
</html>