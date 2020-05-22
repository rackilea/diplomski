// Your current code in the mousemove listener
MousePosition currentPos = new MousePosition(mouseX, mouseY);
mousePosArray.add(0, currentPos);
setMousePosArray(mousePosArray);
System.out.println(mousePosArray.get(0));

// Add this to run all the listeners that have been added to the canvas
mouseMoveListeners.forEach(Runnable::run);