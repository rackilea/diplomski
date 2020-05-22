$.each($(".nameClass"), function(index, item) {
    $(item).autocomplete({
       source:function(request,response){
    $.ajax({
    url: "www.getmeSomeData.com/query/name:"+request.term,
    type:"GET".
    dataType:"json",


success:function(result){
    //set this result in autocomplete which I am not sure how to do
      response($.map(data.data, function(item){
                  return{
                  value:item.somethigncomingfromJson //will set into the field
                  data:item
                }}))}}
     });
    } ,minLength :2,
    select:function(event,ui){
   //do something on select of a row in the autocomplete dropdown
    }}).data("ui-autocomplete")._renderItem=function(ul,item){
   return $("format in which you want to see the data").appendTo(ul);
   });
  }