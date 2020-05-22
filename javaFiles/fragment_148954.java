$.getJSON('getMunicipios'),estado,function(data){
    $('.result').html(''+data.estados+'');
    $.each(data.estados,function(index,value){
        var opcion= $('<option>').attr('value', value);
        var municipio = $("#municipios");
        console.log(value);
        municipio.append(opcion);
    });
});