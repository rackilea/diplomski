<html>
<head>
    <script>
    function escapeSpecialCharacters(obj) {
        var value = obj.value;
        value = value.replace("<","");
        value = value.replace(">","");
        value = value.replace("(","");
        value = value.replace(")","");
        value = value.replace("'","");
        value = value.replace("/","");
        obj.value = value;
    }
    </script>
</head>
<body>
    <input type="text" id="firstName" name="firstName"  onchange="return escapeSpecialCharacters(this);" size="30" maxlength="25">
</body>
</html>