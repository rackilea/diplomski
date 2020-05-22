function submitForm(){
   var prodId = document.getElementById("productId").value;   
   $.ajax({
       url : '/product/'+prodId;
       ... 
  })
}