function onOpened() {
    alert("Channel opened!");
}

function onMessage(msg) {
    alert(msg.data);
}

function onError(err) {
    alert(err);
}

function onClose() {
    alert("Channel closed!");
}