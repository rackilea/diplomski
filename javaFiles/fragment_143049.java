function updateIndexedInputNames($container, name){
    $container.each(function(containerIndex, container){
        $(this).find("input,select").each(function(index, element){
            $(element).attr("name", name+"["+containerIndex+"]."+element.name);
        });
    });
}