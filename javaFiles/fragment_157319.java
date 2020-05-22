$.ajax({
  url: '/ReservationServlet',
  type: 'PUT',
  data: "choose-time=10AM&choose-service=sphincterotomy",
  success: function(data) {
    alert('Load was performed.');
  }
});