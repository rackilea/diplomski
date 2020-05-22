GLFWCharModsCallback charModsCallback = new GLFWCharModsCallback() {
    @Override
    public void invoke(long window, int codepoint, int mods) {
        // do something with the character and modifier flags
    }
};
glfwSetCharModsCallback(window, charModsCallback);