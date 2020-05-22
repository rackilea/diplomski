function delete(row_id) {
        if (window.XMLHttpRequest) {
            xmlhttp = new XMLHttpRequest();
        } else {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
    xmlhttp.open("POST", jsp_url?row_id, false);
    xmlhttp.send(null);
    document.getElementById("table_id").innerHTML = xmlhttp.responseText;
}