$(document).ready(function() {
  $('#AESASJOBRUNOPTION').change(function() {
    var AESASJOBRUNOPTION = $('#AESASJOBRUNOPTION').val();      
    $.ajax({
      type:'POST',     
      url: "AESASJobCurrentOpenPeriod",
      data: {AESASJOBRUNOPTION: AESASJOBRUNOPTION},
      cache: false,
      success: function(result) {
        result_without_path = result.replace(/Served at:[\/a-zA-Z0-9]*/i,'');
        $("#result1").html(result_without_path);
        $("#result1").html(result_without_path).slideDown('slow');
      }
    });
  });
});