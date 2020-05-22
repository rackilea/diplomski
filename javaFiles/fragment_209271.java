public class GamePanel extends JPanel {
    List<BlueSpell> spells;
    Timer timer = null;

    public GamePanel() {
        spells = new ArrayList<>();

        timer = new Timer(40, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                If (spells.size() > 0) {
                    Iterator spellIt = spells.iterator();
                    while (spellIt.hasNext()) {
                        BlueSpell spell = (BlueSpell)spellIt.next();
                        if (spell.collidesWithSomthing()) {
                            // do something, then remove from list
                            spellIt.remove();     
                        } else if (spell.isOffScreen()) {
                            spellIt.remove();  // remove the spell from list
                        } else {
                            spell.animate();  // animate for each tick of timer
                        }
                    }
                }
                repaint();  // just repaint once in each timer tick after all 
            }               // state id update.
        });
        timer.start(); 
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        If (spells.size() > 0) {
             for (BlueSpell spell: spells) {
                  spell.drawSpell(g);
             }
        }
    }
}