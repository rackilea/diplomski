$.ajax({
    url: "./users/remove",
    method: "POST",
    dataType: "json",
    data : {
      "userId" : data.userId,
      "userName" : data.userName 
    },
    success : function(data)
    {
      alert(data.message);
    },
    error : function()
    {
      alert("There was an unexpected error when removing the users.");
    }
});