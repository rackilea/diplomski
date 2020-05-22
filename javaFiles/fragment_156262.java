source.addEventListener('message', function (e) {
    var state = JSON.parse(e.data);
    console.log("New state: " + state.text);
    var element = document.getElementById("state");
    element.innerHTML = state.text;
}, false);