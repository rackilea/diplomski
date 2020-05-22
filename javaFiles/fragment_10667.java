<script>
function validation() {
   var x = document.forms["myform"]["username"].value;
    if (x == null || x == "") {
        alert("username cannot be empty..!!");
        return false;
    }
</script>