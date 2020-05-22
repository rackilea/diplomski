public void forward() {
  switch (orientation) {
    case "north":
      if (grid.isValid(position.x, position.y+1)) {
        position.y += 1;
      } else {
        System.out.println("Can't go there!");
      }
      break;
    ...
}