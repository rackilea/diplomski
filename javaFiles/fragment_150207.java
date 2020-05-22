ro = new RemoteObject();
ro.destination = "destination"; // configured in blazeds/tomcat server
var cs:ChannelSet = new ChannelSet();
var customChannel:Channel = new AMFChannel("my-amf", "http://your-amf-channel");
cs.addChannel(customChannel);
ro.channelSet = cs;             
ro.addEventListener(ResultEvent.RESULT,
    function(e:ResultEvent):void{       
        if (e.result != null)
        {                       
            // you have a result...
                   this.chartData = e.result;
        }               
    });         
ro.addEventListener(FaultEvent.FAULT,function(e:FaultEvent):void{ 
 // manage the error
});         

ro.getValuesFromChart();