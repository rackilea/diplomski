$.ajax({
      type : "POST",
      url: "startapp",
      data:{ processDateInput: processDate,secretToken:tokenLocal},
      dataType: "json",
      async: true,
      success: function(result) {
                            var od = JSON.stringify(result); 
                            var obj = JSON.parse(od);
                            var i = 0;
                            console.log(od);
                            if(obj.redirectUrl){
                                 window.location(obj.redirectUrl);
                            }
      }
});