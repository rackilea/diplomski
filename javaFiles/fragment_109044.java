$j.ajax({type: "GET", url: "LoginHandler",   data:prmVlr,traditional:true,dataType: "json",  cache:false}).done(function(response){
if(response.valido=="1"){ //send 1 if login is valid
     window.location.href = response.redirect;
}
else {
    alert("ERRO NO LOGIN");

}
})
.fail(function(){showMsgAlert('Error'+' - PP-E1003');}); 
}