<script>
   var obj = '${sessionScope.array}';
   var myJSON = JSON.parse(obj); // Convert JSON string to JavaScript object
   console.log("myJSON = " + myJSON);

   $.each(myJSON, function(index, element) {
     document.write('<h4>' + element.cid + '</h4>');
   });
</script>