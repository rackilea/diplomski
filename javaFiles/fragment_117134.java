<script>
    var myJsList= { };
    $.ajax({
        url: '${pageContext.request.contextPath}/MyControllerUrl',
        dataType: 'json',
        async: false,
        success: function(objectInfo) {
            $.each(objectInfo, function(key, object) {
                myJsList[object.code] = object.label;
            });
        }
    });
</script>