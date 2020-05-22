function communicateWithServer() {
  document.getElementById("preloader").style.display = 'block';
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      //show success
    } else {
      //show error
    }
    document.getElementById("preloader").style.display = 'none';
  };
  xhttp.open("GET", url, true);
  xhttp.send();
}