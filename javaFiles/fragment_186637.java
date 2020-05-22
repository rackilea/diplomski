package blockspeak;

import org.antlr.v4.runtime.misc.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * A class extending the `BlockSpeakBaseListener` (which will be generated
 * by ANTLR) in which we override the methods in which to create blocks, and
 * in which to stack blocks.
 */
public class EvalBlockSpeakListener extends BlockSpeakBaseListener {

    // A map that keeps track of our Blocks.
    private final Map<String, Block> blocks = new HashMap<String, Block>();

    @Override
    public void enterCreate_block(@NotNull BlockSpeakParser.Create_blockContext ctx) {

        String name = ctx.NAME().getText();
        Integer x = Integer.valueOf(ctx.position().x.getText());
        Integer y = Integer.valueOf(ctx.position().y.getText());

        Block block = new Block(name, x, y);

        System.out.printf("creating block: %s\n", name);

        blocks.put(block.name, block);
    }

    @Override
    public void enterStack_block(@NotNull BlockSpeakParser.Stack_blockContext ctx) {

        Block bottom = this.blocks.get(ctx.bottom.getText());
        Block top = this.blocks.get(ctx.top.getText());

        if (bottom == null) {
            System.out.printf("no such block: %s\n", ctx.bottom.getText());
        }
        else if (top == null) {
            System.out.printf("no such block: %s\n", ctx.top.getText());
        }
        else {
            System.out.printf("putting %s on top of %s\n", top.name, bottom.name);
            top.onTopOf(bottom);
        }
    }
}