function getUser() {
  google.script.run
  .withSuccessHandler(function(user) {
    document.getElementById('userdiv').innerHTML=user;
  })
  .getUser();
}