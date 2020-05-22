function(err) {
  // Make html document from response html string
  var div = document.createElement('div');
  div.innerHTML = err.data;
  // Get html element with error message
  var messageBlock = div.querySelector('h1');
  var message = 'Error on server';
  if (messageBlock) {
    // you can parse you message if it's needed
    message = messageBlock.innerText;
  }
  alert(message); // HTTP Status 500 - ...... can't purchase a coupon...
}