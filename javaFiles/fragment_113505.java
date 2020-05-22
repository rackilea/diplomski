<s:iterator value="test" id="countryList" status="stat">
  <tr>
    <td><s:textfield name="countryList[%{#stat.index}].countryCode" value="%{countryCode}" theme="simple" /></td>
    <td><s:textfield name="countryList[%{#stat.index}].countryName" value="%{countryName}" theme="simple" /></td>
  </tr>
 </s:iterator>