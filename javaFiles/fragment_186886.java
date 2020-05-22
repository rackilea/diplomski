package wall;

import java.util.Random;
import java.util.concurrent.Callable;

import com.jme.math.Vector3f;
import com.jme.scene.shape.Sphere;
import com.jme.util.GameTaskQueueManager;
import com.jmex.editors.swing.settings.GameSettingsPanel;
import com.jmex.game.StandardGame;
import com.jmex.game.state.DebugGameState;
import com.jmex.game.state.GameStateManager;

public final class SphereExample {

    private static final int MAX = 100;
    private static final int TOTAL = 10000;

    public static void setupGame() {
        final DebugGameState state = new DebugGameState() {
            @Override
            public void update(final float timeStep) {

                // Update the game state
                super.update(timeStep);
            }
        };
        final Random random = new Random();
        for (int i = 0; i < TOTAL; i++) {
            final Sphere sphere = new Sphere("sphere", 5, 5, 1);
            sphere.setLocalTranslation(random.nextInt(MAX),
                    random.nextInt(MAX), random.nextInt(MAX));
            sphere.updateRenderState();
            state.getRootNode().attachChild(sphere);
        }

        GameStateManager.getInstance().attachChild(state);
        state.setActive(true);

    }

    public static void main(final String[] args) throws Exception {

        final StandardGame game = new StandardGame("Points");

        if (GameSettingsPanel.prompt(game.getSettings())) {

            game.start();

            GameTaskQueueManager.getManager().update(
                    new Callable<Void>() {
                        @Override
                        public Void call() throws Exception {
                            setupGame();
                            game.getCamera() // moves the camera to the middle
                                             // of the spheres
                                    .setFrame(
                                            new Vector3f(50.0f,
                                                    50.0f, 50.0f),
                                            new Vector3f(-1.0f, 0.0f,
                                                    0.0f),
                                            new Vector3f(0.0f, 1.0f,
                                                    0.0f),
                                            new Vector3f(0.0f, 0.0f,
                                                    -1.0f));
                            game.getCamera().update();
                            game.getCamera().apply();
                            return null;
                        }
                    });
        }
    }
}