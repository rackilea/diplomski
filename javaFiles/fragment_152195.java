$.ajax({
//options
}).done(function(res){

  $('body').append(res)
  $("td").on('click',function() {
    console.log("testlog");
  });
})