$.ajax({
       type: "POST",
       url: "http://localhost:50366/api/cities",
       data: "{'country':'" + country + "','name':'" + cityName + "'}",
       contentType: "application/json; charset=utf-8",
       dataType: "json",
       success: function (msg) {
             alert(msg.d);
       },
       error: function (msg) {
             alert(msg.d);
       }
      });