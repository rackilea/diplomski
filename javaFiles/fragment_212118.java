$.ajax
({
    type: "POST",
    url: "/login",
    data: $('#frm_login').serialize(),
    success: function(data)
...