$.ajax({
  url: 'login',
  data: form.serialize(),
  type: 'post',
  success: function(data){ 
    $('body').append('<div style="display:none;">'+data+'</div>');
    alert($('#pqId').val());
  }
});