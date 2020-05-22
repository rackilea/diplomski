const net = require('net');
const client = new net.Socket();
client.connect(8080, '<PUBLIC-IP>', () => {
    // callback, when connection successfull
    client.write('Data sent to the App');
});
client.on('data', (data) => {
    // callback, when app replies with data
});
client.on('close', (data) => {
    // callback, when socket is closed
});