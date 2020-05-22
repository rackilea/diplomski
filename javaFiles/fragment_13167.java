if (disc.contains(touchPos.x, touchPos.y)) {
    dragged = true;
}

...

if (dragged) {
    disc.x = touchPos.x - disc.radius / 2; // disc.x becomes current touch position
    disc.y = touchPos.y - disc.radius / 2; // disc.y becomes current touch position
}

...

public onMouseUp() {
     dragged = false;
}