<html><head>
<script>
  function test() {
    var e = document.getElementById('myid');
    e.checked = true;
    alert(e.outerHTML);
  }
</script>
</head><body onload="test()">
  <input type=checkbox id=myid>
</body></html>