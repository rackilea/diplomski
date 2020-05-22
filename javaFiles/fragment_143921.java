<head>
...
<script>
    $(document).ready(function() {                        
       $('#submit').click(function(event) {  
          var input=$('#userinput').val();
          $.get('ActionServlet',{userinput:input},function(responseText) { 
             $('#underInput').text(responseText);         
          });
        });
    });
</script>
...
</head>
<body>
...
<form id="form1">
...
Email
<input type="text" id="userinput"/>
<input type="button" id="submit" value="Submit"/>
<br/>
<div id="underInput">
</div>
...
</form>
...
</body>
</html>