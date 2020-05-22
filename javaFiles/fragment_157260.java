<form action="myServlet" onSubmit="setVal();">
<input type="hidden" id="id" value="" name="total">
     <input type="submit" value="Go!"/>

</form>

<script>        

function setVal(){
   var a = 2;
    document.getElementById('id').value=a;
}
</script>