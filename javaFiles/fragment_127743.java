function getrelease(releaseId){
  $.ajax({
    url:"yourURL",
    type:"post",
    data:{
       id_release:id_release
    },
    success:function(data){
       $("#"+releaseId).html(data);
    }
  });
}