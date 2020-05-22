$("#confirm-reject").modal('hide');
var url = "userHome";
//on click of reject button
$('button[name="accept"]').on("click", function() {
  //getting current value of button click
  var action = $(this).attr('data-href');
  $("#loader").show();

  //opening modal
  $("#confirm-reject").modal('show');
  //on click of Yes,Reject button
  $("#action").on("click", function() {
    console.log(action);
    $.ajax({
      url: url,
      type: 'Post',
      data: {
        action: action
      },

      success: function(result) {
        $('.loader').hide();
        $('#confirm-reject').modal('hide');
        var successUrl = "userHome.jsp";
        window.location.href = successUrl;
      },
      error: function(jqxhr) {
        $('.loader').hide();
        $('#action').html("<font color='red'>Something went wrong. Please refresh and try again.</font>");
        return false;
      }
   });

  });

});