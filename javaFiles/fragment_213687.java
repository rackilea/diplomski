client.on('message', function (topic, message, packet) {
    const regex = /\{(.*)\}$/g;
    const match = message.toString().match(regex);
    if(null === match) {
        console.error("Could not parse message");
        console.log('message', message.toString());
    }
    const json = JSON.parse(match[0]);
    console.log('message', json);
});