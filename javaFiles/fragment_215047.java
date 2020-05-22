FB.api(
  '/me',
  'GET',
  {"fields":"id,name,friends{likes,name}"},
  function(response) {
      // Insert your code here
  }
);