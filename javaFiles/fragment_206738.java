<ol>
<s:iterator value="puntate" status="ctr">
    <s:url action="episodi" var="episodio">
        <s:param name="id">
            <s:property value="idPuntate[%{#ctr.index}]"/>
        </s:param>
    </s:url>

    <li><a href="<s:property value='#episodio'/>"><s:property/></a></li>
</s:iterator>
</ol>