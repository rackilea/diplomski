<s:iterator value="empList" status="emp">
    <s:textfield name="eno" value="%{empNo}"/>
    <s:textfield name="eName" value="%{empName}"/>
    <s:hidden name="empList[%{#emp.index}].eno" value=%{empNo}/>
    <s:hidden name="empList[%{#emp.index}].ename" value=%{empName}/>
</s:iterator>