TestPlugin.test(
    "hubiao",
    function(){
        alert("success");
    },
    function(e){
        alert("fail");
        // log() is undefined.  console.log() is defined!
        console.log(e);
        // Or more likely you want the error message only
        console.log(e.message);
    }
);