pageMod.PageMod({
  include: ["https://play.google.com/*"],
  contentScriptWhen: 'ready',
  contentScriptFile: [data.url("jquery.js"),data.url("jquery.knob.js"),data.url("purl.js"),data.url("content.js")],
  contentScriptOptions: {
    inUrl: data.url("in.png"),
    outUrl: data.url("out.png"),
    logoUrl: data.url("logoimage.png")
  },
  contentStyleFile: [data.url("css/inject.css")],
  onAttach: function(worker) {//Ttach
    alert("hello there")
    worker.port.on("message",function(){
//THIS IS THE CORRECT CODE
        worker.port.emit("alert",{message:"Hello"});
    })

  }
});