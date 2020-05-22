$("#byCollege").change(function() {
  $("select option:selected").first().each(function() {
    // Get and convert the data for sending
    // Example: This variable contains the selected option-text
    var outdata = $(this).text();
    // Send the data as an ajax POST request
    $.ajax({
      url: "yourjsonservlet",
      type: 'POST',
      dataType: 'json',
      data: JSON.stringify(outdata),
      contentType: 'application/json',
      mimeType: 'application/json',
      success: function(data) {
        // Remove old select options from the DOM                     
        $('#byCollege')
          .find('option')
          .remove()
          .end();
        // Parse data and append new select options 
        //(omitted here; e.g. $('#byCollege').append($("<option>").attr(...))                         
      },
      error: function(data, status, er) {
        alert("error: " + data + " status: " + status + " er:" + er);
      }
    });
  });
});