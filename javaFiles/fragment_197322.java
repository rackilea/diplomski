package game;

import entity.Block;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import world.Camera;
import world.World;

import java.util.ArrayList;
import java.util.List;

public class TestState extends BasicGameState {
    /**
     * This variable sets
     * the gird size, and the block's
     * size.
     */
    private final int size = 50;

    /**
     * This list contains/stores the blocks
     * who going to be rendered.
     */
    private final List<Block> blocks = new ArrayList<>();

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        /**
         * DRAW THE GRID
         *
         * This can be confusing
         * for the first look, but its logical.
         */
        g.setColor(Color.white);

        for (int i = 0; i < 50; i++) {
            float y = i * size;
            float x = 0;
            g.drawLine(x, y, gc.getWidth(), y);

            for (int i2 = 0; i2 < 50; i2++) {
                float x2 = i2 * size;
                g.drawLine(x2, y, x2, gc.getHeight());
            }
        }

        // DRAW EACH BLOCKS (this is a for-each loop)
        for (Block block : blocks) {
            block.render(gc, g);
        }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        // ADD NEW BLOCK IF MOUSE PRESSED
        if (gc.getInput().isMouseButtonDown(0)) {

            // get the x and y positions
            float x = (float) Math.ceil(gc.getInput().getMouseX() / size * size);
            float y = (float) Math.ceil(gc.getInput().getMouseY() / size * size);

            /**
             * The block class has a
             * special constructor because
             * I built it for my game.
             * You should build your own.
             *
             * The block is *size by *size sized :D
             * I mean the *size is the variable.
             * Ohh, and it's uses the x & y positions.
             */
            blocks.add(new Block(new World(new Camera()), new Camera(), new Rectangle(x, y, size, size)));
        }
    }
}