$.ajax({
      url:"/delete",
      data: {empno:array},
      dataType: 'text',
      type: 'POST',
      success: function(result){
        if(result==1)  
          alert('delete complete');
          location.href='/index';

      }
  });