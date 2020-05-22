public void left() {
  switch (orientation) {
    case "north": orientation = "west"; break;
    case "east": orientation = "north"; break;
    ...
  }
}