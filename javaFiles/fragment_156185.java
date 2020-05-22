public class KeyboardCallback extends GLFWKeyCallback {
    private static boolean[] keys = new boolean[65536];

    @Override
    public void invoke(long window, int key, int scancode, int action, int mods) {
        keys[key] = action != GLFW_RELEASE;
    } 

    //The keyCode will come from GLFW.GLFW_KEY_ and then whatever key that you want!
    public static boolean isKeyDown(int keyCode) {
        return keys[keyCode];
    }
}