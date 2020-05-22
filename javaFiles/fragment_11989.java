<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>IE8 Test</title>
</head>

<body>

<button id="b2" type="button" value="button">Button type</button>

<button id="b1">No type</button>

<button id="b3" type="submit" value="submit">Submit type</button>

<input type="text" value="text!">

<script>
    document.getElementById('b1').onclick = function (e) {
        alert("You Clicked Button Number 1");
    };

    document.getElementById('b2').onclick = function (e) {
        alert("You Clicked Button Number 2");
    };

    document.getElementById('b3').onclick = function (e) {
        alert("You Clicked Button Number 3");
    };

</script>
</body>
</html>