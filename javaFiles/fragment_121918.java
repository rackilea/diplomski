// Global:
array keysdown;
keysdown[left] = false;
keysdown[right] = false;
keysdown[up] = false;

// The all-important game loop:
while (true) {
    pollInputs();
    doMovement();
    draw();
}

function pollInputs () {
    foreach (key that you want to handle) {
        if (key.state == down) {
            keysdown[key] = true;
        } else {
            keysdown[key] = false;
        }
    }
}

function doMovement () {
    if (keysdown[left]) {
        // move character left
    } else if (keysdown[right]) {
        // move character right
    }

    if (keysdown[up]) {
        // initiate jump
    }
}