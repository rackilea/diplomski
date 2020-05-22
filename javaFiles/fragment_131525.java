$(document).ready(function() {
  $("#submit").click(function(e) {
    e.preventDefault();
    var id = $("input#id").val();
    var psswd = $("input#psswd").val();
    var query = {
      id: "id",
      psswd: "psswd"       
    };

  $.ajax({
      type: "POST",
      url: "process.jsp",
      data: query,
      success: function(data) {
        $("#result").html(data);
      }
    }); 
  });
});