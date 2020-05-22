$('#save').click(function(){
    vertices = "";
    for (var i=0; i<polygons.length; i++) {
        vertices += "polygon "+i+"<br>";
        for (var j=0; j<polygons[i].getPath().getLength(); j++) {
            vertices += polygons[i].getPath().getAt(j).toUrlValue(6)+"<br>";
        }
    }
    document.getElementById('verticesclick').innerHTML = vertices;

});