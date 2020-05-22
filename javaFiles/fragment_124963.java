$.ajax({
  url: "your-web-service.php",
  context: document.body,
  dataType: "json",
  success: function(data){
    // do something with data
    $(this).addClass("done");
  }
});