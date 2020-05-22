<s:iterator id="twtFeedAccts" value="twtFeedAccts" status="twtAcct">
            <tr>
                <td width="250">
                    <img src="<s:property  value="%{twtFeedAccts[#twtAcct.index].pic}" />"  width="25px" height="25px"  />
                        <s:property  value="%{twtFeedAccts[#twtAcct.index].name}" />

                </td>   
                <td width="200">
                    <s:textfield id="twtFeedAccts[%{#twtAcct.index}].number" name="twtFeedAccts[%{#twtAcct.index}].number" value="%{twtFeedAccts[#twtAcct.index].number}" />
                </td>
                <td width="200">
                    <s:select id="twtFeedAccts[%{#twtAcct.index}].cycle" name="twtFeedAccts[%{#twtAcct.index}].cycle" value="%{twtFeedAccts[#twtAcct.index].cycle}"
                     label="Select a month"  list="#{'2':'2 hrs','4':'4 hrs', '6':'6 hrs', '12':'12 hrs', '24':'24 hrs'}" />
                </td>
                <td width="250">
                    <s:textfield id="twtFeedAccts[%{#twtAcct.index}].signature" name="twtFeedAccts[%{#twtAcct.index}].signature" value="%{twtFeedAccts[#twtAcct.index].signature}" size="40"/>
                </td>
                <td width="50">
                    <s:checkbox id="twtFeedAccts[%{#twtAcct.index}].selected" name="twtFeedAccts[%{#twtAcct.index}].selected" value="%{twtFeedAccts[#twtAcct.index].selected}"  />
                </td>
            </tr>
            </s:iterator>