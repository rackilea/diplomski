package {
    import flash.display.Sprite;
    import flash.net.registerClassAlias;
    import org.rackAMF.*;
    import flash.net.Socket;
    import flash.events.*;

    public class SocketTest extends Sprite {
        private var socket:Socket;

        public function SocketTest() {
            registerClassAlias('Animal', Animal);

            socket = new Socket();
            socket.addEventListener(ProgressEvent.SOCKET_DATA, onResponse);
            socket.connect("localhost", 8081);
        }

        private function onResponse(e:ProgressEvent):void {
            var animal:Animal = socket.readObject() as Animal;
            trace(Object(animal).constructor); // [trace] [class Animal]
            trace(animal.name); // [trace] Zebra
            trace(animal.age); // [trace] 5
        }
    }
}

class Animal {
    public var name:String;
    public var age:int;
}