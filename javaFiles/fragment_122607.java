GameWindow window = new GameWindow("Test");
GameScreen screen = new GameScreen(800, 600);
Sandbox sandbox = new Sandbox();

window.add(screen);
window.pack();
window.setVisible(true);