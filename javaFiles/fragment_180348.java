<html>
<script>
    var counter = 0;
    function openWindow(){
        window.open('http://www.google.com','mywindow'+counter,'width=400,height=350');
        counter++;
    }
</script>
<body>
    <input type="button" value="button" id="button" onclick="openWindow()" />
</body>
</html>