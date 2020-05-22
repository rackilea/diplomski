$(document).ready(function(){

$.getJSON("Test.json",function(data){

         $.each(data,function(key,value){
             alert(data[key].activities);
             alert(data[key].enterpriseName); 
             $('input').val(data[key].enterpriseName);
             activities=data[key].activities;
             console.log(value);
         });
     });    


});