<script>
   new Ajax.Request('/some_url?name=apple&price=12', {
   method:'post',
   onSuccess: function(transport) {
   var response = transport.responseText || "no response text";
   alert("Success! \n\n" + response);
 },
   onFailure: function() { alert('Something went wrong...'); }
});
</script>