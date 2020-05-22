//get the url
$old_url = "http://".$_SERVER['HTTP_HOST'].$_SERVER['REQUEST_URI'];

//then you modify it
$new_url = ...; 

//then with javascript you replace the url with the new one
<script type="text/javascript">
   if(new_url != '')
   {
      window.history.replaceState({"html":'Title',"pageTitle":'Page Title'}, '', new_url);
   }
</script>