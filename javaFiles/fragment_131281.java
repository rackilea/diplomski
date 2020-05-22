// ...

javaServer.on('connection', function(javaSocket){
  var clientAddress = javaSocket.address().address+':'+javaSocket.address().port;
  console.log('Java ' + clientAddress + ' connected');
  javaSocket.on('data', function(data){
    fileData = data;
    console.log('Data recieved from java: ' + fileData);
  }).on('close', function() {
    console.log('Java ' + clientAddress + ' disconnected');
  });
});

javaServer.listen(javaPort);