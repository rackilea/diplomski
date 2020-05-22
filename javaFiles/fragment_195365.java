<s:iterator value="rows" status="row">

    <s:file      name="rows[%{#row.index}].fileUpload" />

    <s:textfield name="rows[%{#row.index}].otherField1"/>
    <s:textfield name="rows[%{#row.index}].otherField2"/>

</s:iterator>