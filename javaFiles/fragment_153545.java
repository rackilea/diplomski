$('#ss').click(function(){
 
 var txt =  $("#txtShareCount").val();      
        if(txt.trim().match(/^[\d]+([-][\d]+)?$/g)){
  
            alert("hi valid format ");
            }           
        else if(!txt.trim().match(/^[\d]+([-][\d]+)?$/g)){
            alert("Pleae Enter Share count this(1-10) format");
            $("#txtShareCount").focus();
            return false;
            }
        else{
   
         alert("hi valid format ");
            }
  
 });