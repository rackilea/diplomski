function showProgress(data) {
    var inputElement = data.source; // The HTML DOM input element.
    var ajaxStatus = data.status; // Can be "begin", "success" and "complete"

    var messageForInputElement = document.getElementById(inputElement.id + "_message");

    switch (ajaxStatus) {
        case "begin": // This is called right before ajax request is been sent.
            messageForInputElement.innerHTML = "validating...";
            break;

        case "complete": // This is called right after ajax response is received.
            messageForInputElement.innerHTML = "";
            break;

        case "success": // This is called when ajax response is successfully processed.
            if (messageForInputElement.innerHTML.length == 0) { // So, no message has been set.
                messageForInputElement.innerHTML = "valid!";
            }
            break;
    }
}