function JS_ADD(elem,callurl) 
{
if(callurl == 'Add ALIAS')
{


var parameterID = document.getElementById('parameterID').value; 

var newFormData=[];
    jQuery('#myTable tr:not(:first)').each(function(i){
        var tb=jQuery(this);
        var obj={};
        tb.find('input').each(function(){
           obj[this.name]=this.value;
        });
        //  obj['row']=i;
        newFormData.push(obj);

    });



   $.ajax
   ({
     type: "POST",
     contentType: "application/json; charset=utf-8",
     url: "/parameters/alias/"+parameterID,
     data: JSON.stringify(newFormData),
      success: function(data) 
      {
       if(data.error) return;
       $(document).ajaxStop(function() { location.reload(); }); 
      }
   });


}
}