$(".deleteBox").change(function(){
    // use $(this) to check state of current changed checkbox
    if($(this).prop("checked")){
      console.log("true");
      $("#deletePanel").css("display","inline");
    }else{
      $("#deletePanel").css("display","none");
      console.log("false");
    }
});