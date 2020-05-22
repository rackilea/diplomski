$("select#offenceCatId").change(function(){
        var param={crimeCatId:$(this).val()};
        $.ajax({
            type:'GET',
            url:'getCrimeTypeList.htm',
            data:param,
            success:function(data){
                //append options to list
            }
        });
});