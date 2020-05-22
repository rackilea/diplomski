$.ajax({
  url: "YourSeveletPathName",
  type: 'GET',
  success: function(response) {
    //console.log(response);
    //map your data here -  to  series parameter in your highchart method.
  },
  error: function(error) {
    errorFunction(error, parameter);
  }
});