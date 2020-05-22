function selectTransport(value){
//value return a,b,c
var val = $('#select-choice-1 [value="'+value+'"]').html();//.text()
  if(val==="Thermoplastic"){alert('test');
    var theText = "2345-Blue";
    $("#select-choice-2 option:contains(" + theText + ")").attr('selected', 'selected');
  }
}