...
// introduce this class to hold a block
class Block{
    public int x;
    public int y;
    public Block(int _x, int _y){
        x = _x;
        y = _y;
    }
}
...
// boolean setBlock;  // remove this boolean
ArrayList<Block> blocks = new ArrayList<Block>();  // list of all blocks

public platform(){...}

public void paint(Graphics g){
    ...    
    // if(setBlock){  // remove this boolean

        if(playerDirection == 0){
            g2.fillRect(playerx, playery, 50, 50);
        }else if(playerDirection == 1){
            g2.fillRect(playerx, playery, 50, 50);
        }else if(playerDirection == 2){
            g2.fillRect(playerx, playery, 50, 50);
        }else if(playerDirection == 3){
            g2.fillRect(playerx, playery, 50, 50);
        }
        // draw the blocks
        for(Block b : blocks)
            g2.fillRect(b.x, b.y, 50, 50);

        // setBlock = false; // remove this boolean
    //}  // remove this boolean
}

public void keyPressed(KeyEvent e) {
    ...
    if(e.getKeyCode() == KeyEvent.VK_SPACE){
        // setBlock = true;  // remove this boolean
        // add a new block
        blocks.add(new Block(playerx, playery));
        repaint();
    }
}
...