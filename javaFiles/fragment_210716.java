public function loaded():void
{
   var token:AsyncToken = ro.sayHello();
   token.addResponder(new mx.rpc.Responder(result, fault));
   // ...Code continues to execute...
}

public function result(event:ResultEvent):void
{
   // The byte[] is in event.result
   var bArr:ByteArray = event.result as ByteArray;
}

public function fault(event:FaultEvent):void 
{
   // Something went wrong (maybe the server on the other side went AWOL) 
}