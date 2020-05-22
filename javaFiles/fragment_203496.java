window.websocket = new WebSocket("ws://localhost:8000");
      window.websocket.onopen = () => {
        window.websocket.send("Hello");
      };

      window.websocket.onmessage = function(event) {
        alert("Hi");

        console.log(event.data);
      };