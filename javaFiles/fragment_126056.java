$(document).ready(function() {
  var divToChange = $('#message');//div id of the message you show to user
  $.ajax({
    type: 'POST',
    url: 'checkReport.jsp',
    data: {},
    beforeSend:function(){
        divToChange.html('Loading...');
    },
    success:function(data){
        divToChange.html(data);
    },
    error:function(){
        divToChange.html('Checking file failed!');
    }
  });
)};