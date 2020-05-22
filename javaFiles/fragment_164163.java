connect()
  {
    try
    {
      this.webSocket = new WebSocket(this.getServerUrl());

      // Implement WebSocket event handlers!
      this.webSocket.onopen = function (event)
      {
        console.log('onopen :: ' + JSON.stringify(event, null, 4));
      };

      this.webSocket.onmessage = function (event)
      {
        var msg = event.data;
        console.log('onmessage ::  ' + JSON.stringify(msg, null, 4));
        var output = document.getElementById("time");
        output.innerHTML = msg;
      };
      this.webSocket.onclose = function (event)
      {
        console.log('onclose :: ' + JSON.stringify(event, null, 4));
      };
      this.webSocket.onerror = function (event)
      {
        console.log('onerror :: ' + JSON.stringify(event, null, 4));
      };

    }
    catch (exception)
    {
      console.error(exception);
    }
  }