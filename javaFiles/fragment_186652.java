<!DOCTYPE HTML>
<html>
<body>

<button type="button" onclick="connect();">Connect</button>
<button type="button" onclick="connection.close()">Close</button>


<form>
<input type="text" id="msg" />

<button type="button" onclick="sayHello();">Say Hello!</button>

<script>
var connection;



function connect() {
    console.log("connection");
    connection = new WebSocket("ws://localhost:2005/");
    // Log errors
connection.onerror = function (error) {
  console.log('WebSocket Error ');
  console.log(error);

};

// Log messages from the server
connection.onmessage = function (e) {
  console.log('Server: ' + e.data); 
  alert("Server said: " + e.data);
};

connection.onopen = function (e) {
console.log("Connection open...");
}

connection.onclose = function (e) {
console.log("Connection closed...");
}
}


function sayHello() {
    connection.send(document.getElementById("msg").value);
}

function close() {
    console.log("Closing...");
    connection.close();
}
</script>
</body>

</html>