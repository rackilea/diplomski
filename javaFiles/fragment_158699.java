$.ajax(contextPath,{
  type:'POST',
  data:{ 'actionToPerform': methodName,
         'param1': param1,
         'param2': param2
       },

  success: function(response){
  },
  error : function(response){
  }
  });