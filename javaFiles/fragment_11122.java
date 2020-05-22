saveUser : function(e){
  // This will prevent the form from submitting normally.
  e.preventDefault();
  var user = new User();
  user.save(
    {
      firstName: $('#firstname').val() 
      ,lastName: $('#lastname').val() 
      ,age: $('#age').val() 
    },
    {
      success :  function(user){
        console.log('INSIDE SUCCESS..')
        router.navigate('',{trigger:'true'});
      }
     }
  );
}