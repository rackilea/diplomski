public static void init(){
        GLProfile.initSingleton();
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities caps = new GLCapabilities(profile);

        window = GLWindow.create(caps);
        window.setSize(640, 360);
        window.setResizable(false);
        window.setVisible(true);
        FPSAnimator animator = new FPSAnimator(window, 30);
        animator.start();
    }