GLFWImage image = GLFWImage.malloc();
image.set(width, height, buf);
GLFWImage.Buffer images = GLFWImage.malloc(1);
images.put(0, image);

glfwSetWindowIcon(window, images);

images.free();
image.free();