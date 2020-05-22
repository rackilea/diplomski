IntBuffer pLeft = stack.mallocInt(1); // int*
IntBuffer pTop = stack.mallocInt(1); // int*
IntBuffer pRight = stack.mallocInt(1); // int*
IntBuffer pBottom = stack.mallocInt(1); // int*

// Get the window border sizes
glfwGetWindowFrameSize(window, pLeft, pTop, pRight, pBottom);