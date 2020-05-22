if (!ignoreMouseMove) {
    ignoreMouseMove = true;
    // Do your normal processing...
    robot.mouseMove(...);
} else {
    ignoreMouseMove = false;
}