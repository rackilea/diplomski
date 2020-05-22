$("#id_of_textbox1").keyup(function(event){
  if(event.keyCode == 13){
    $("#id_of_button1").click();
  }
});

$("#id_of_textbox2").keyup(function(event){
  if(event.keyCode == 13){
    $("#id_of_button2").click();
  }
});