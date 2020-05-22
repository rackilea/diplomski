$("#button").click(function(){
  var searchKey = $('#keySearchText').val(); // Selector could be different. 
  var searchUrl = sRoutes.controllers.UserController.getUserKeySearch(searchKey).url;
  $.ajax({url: searchUrl, success: function(result){
    console.log(result);
  }});
});