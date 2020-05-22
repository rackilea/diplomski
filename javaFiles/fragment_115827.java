$(document).ready(function(){
      $("#button").click(function (){

          var name = $('#name').val(); //your code has  $(#name) which is not selecting required input element!
         $.post("/cardselector/mailAction.do",{"name" : name},function(response) 
          {
                alert("done");
                console.log(response); //see what response you are getting        
         });
      })