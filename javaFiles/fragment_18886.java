<html>

<head>
<script language="JavaScript"><!--
  function refreshIt() {
    if (!document.images) return;
      var date = new Date();
    document.images['image'].src = 'http://localhost:8080/image.jpg?ts=' + date.getTime();
      setTimeout('refreshIt()',2000); // refresh every 2000ms
 }
  //--></script>
</head>

<body onLoad=" setTimeout('refreshIt()',2000)">

<img src="http://localhost:8080/image.jpg" name="image">

</body>

</html>