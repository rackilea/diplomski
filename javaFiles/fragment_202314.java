const app = require('express')();
const server = app.listen(3000);
const io_local = require('socket.io')(server);

io_local.on('connection', (socket) => {
    console.log('New connection!');

    socket.on('poke', () => {
        console.log("poked");
    });

    socket.on('error', () => {
        console.log("error");
    });

    socket.emit('error', {message: "error"});
});