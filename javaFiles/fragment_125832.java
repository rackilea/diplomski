<script>
$( document ).ready(function() {
    $("#consultantListIntAva").change(function(){
    var optionValue = $("#consultantListIntAva").val();
    var id = optionValue.substring(optionValue.indexOf(',')+1,optionValue.length);
    alert(id);
});
});
</script>