$.ajax({
    url: "./users/remove",
    method: "POST",
    dataType: "text",
    data : {
      "userId" : data.userId,
      "userName" : data.userName 
    },
    success : function(data)
    {
      alert(data);
    },
    error : function()
    {
      alert("There was an unexpected error when removing the users.");
    }
});