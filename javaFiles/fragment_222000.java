$(function() {
  $("#formID").on("submit",function(e) { // pass the event
    e.preventDefault(); // cancel submission
    $.post(this.action,$(this).serialize(),function(data) {
      $("#resultID").html(data); // show result in something with id="resultID"
      // if the servlet does not produce any response, then you can show message
      // $("#resultID").html("Payment succeeded");
    });
  });
});