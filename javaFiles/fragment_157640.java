<html>
<head>
<script>
function submitter(btn) {
    var param = btn.parentElement.parentElement.id;
    var myForm = document.forms["myForm"];
    myForm.elements["param"].value = param;
    myForm.submit();
}
</script>
</head>
<body>
<form action="#someurl" id="myForm">
<input type="hidden" name="param" />
<table border="1" style="width: 100%" id="mytab1">
<tr id="A1">
    <td>100</td>
    <td>John</td>
    <td>Doe</td>
    <td>Someplace</td>
    <td>
        <input type="button" value="Submit" onclick="submitter(this)" />
    </td>
</tr>
<tr id="A2">
    <td>101</td>
    <td>Jane</td>
    <td>Doe</td>
    <td>Someplace</td>
    <td>
        <input type="button" value="Submit" onclick="submitter(this)" />
    </td>
</tr>
</table>
</form>
</body>
</html>