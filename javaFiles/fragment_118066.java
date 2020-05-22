$.get(
    '/manager/echoVariables',
    {var1: "foo", var2: 5},
    function(responseText){
        $("#result").html(JSON.stringify(responseText));
    },
    "json"
);