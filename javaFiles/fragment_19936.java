function myAlertFunction(event) {
  event.preventDefault()
  swal({
      title: "Remove book?",
      text: "Watch out",
      type: "warning",
      showCancelButton: true,
      confirmButtonColor: "#DD6B55",
      confirmButtonText: "Yes.",
      cancelButtonText: "No.",
      closeOnConfirm: false,
      closeOnCancel: false
    },
    function(isConfirm) {
      if (isConfirm) {
        swal({
          title: "Deleted.",
          text: "Done.",
          type: "success"
        }, function() {
          $("#remove_book").submit();
        });
      } else {
        swal("Cancelled", "Not done.", "error");
      }
    });
}