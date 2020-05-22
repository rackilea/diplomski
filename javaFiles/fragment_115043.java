$.ajax(
{
    type: 'POST', 
    url: '<s:url action="action1"/>',
    data: { field1 : selectedValue},
    //async: false ,
    success: function(data){
      alert(data);
    }
 });