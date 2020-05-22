void updateCamera() {
    if (LeftShiftPressed()) {
        RotateCamera(getNormalizedX());
    } else {
        PanCamera(getNormalizedX());
    }
}

float getNormalizedX() {
    return float(getDeltaX()) / float(getScreenWidth())
}

void PanCamera(float x_movement) {
    // pan by x_movement * pan_multiplier
}

void RotateCamera(float x_movement) {
    // rotate by x_movement * rotation_multiplier
}