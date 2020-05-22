<script>
    var mainObject = $('#mainForm').serializeObject();
    var modelObject = [];
     $('.modelform').each(function(o){
        modelObject.push($(this).serializeObject());
    })
    mainObject.marks = modelObject;
</script>