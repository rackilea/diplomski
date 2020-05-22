$("#state").change(function() {         
    state_id = $(this).val();
    $.ajax({
        url : "<portlet:resourceURL id='CityCall'/>",
        type : 'POST',
        dataType : 'json',
        data : { state_id : state_id},
        success : function(data) {
            console.log(JSON.stringify(data));
            for(var i in data)
            {
                $("#city").append("<option value=" + data[i].city_id + ">" + data[i].city_name + "</option>");
            }
        },
        error : function() {
            console.log("There was an error. Try again please!");
        }
    });
});