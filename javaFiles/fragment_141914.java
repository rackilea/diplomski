function functionname(data) {
    var ajaxStatus = data.status; // Can be 'begin', 'complete' and 'success'.

    switch (ajaxStatus) {
        case 'begin': // This is called right before ajax request is been sent.
            // ...
            break;

        case 'complete': // This is called right after ajax response is received.
            // ...
            break;

        case 'success': // This is called when ajax response is successfully processed.
            // ...
            break;
    }
}