function ajaxsubmit(){
    $.ajax({
        url: "/update",
        type: "POST",
        dataType: "html"
    }).success(function(data) {
          $('#result').html(data);
      });
    }