$("#saveChanges").on('click',function(){
   var params1={
     proxy:$(proxy).val() ,
     port:$(port).val(),
     uri:$(uri).val(),
     actived:$(actived).is(':checked')
   };
   
         $.ajax({
             url: 'notification/save/'+id,
             data: params1,
             type: 'post',
             success:function(response) {