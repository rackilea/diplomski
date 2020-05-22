$('#certificate_document_other').on("change",function(){
 var objFormData=new FormData();// to capture all form form information inform of object
 var objFile= $(this)[0].files[0];
 objFormData.append('file',objFile);
 $.ajax({
   url:"/SomeProjetName/fileUpload",
   type: "POST",
   enctype:"multipart/form-data",
   data:objFormData,
   contentType:false,
   processType:false,
   success: function(data){
      alert('upload SuccessFull');

},error:function(xhr,status,errorType){
    alert(xhr.status);
    alert(xhr.responseText);
}


});
});