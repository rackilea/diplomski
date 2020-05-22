import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.ggl.horse.race.model.Race;

public class RacePanel extends JPanel {

    private static final long   serialVersionUID    = 1040577191811714944L;

    private Race race;

    public RacePanel(Race race) {
        this.race = race;
        int width = race.getTrackWidth();
        int height = race.getTrackHeight();
        this.setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);
        race.draw(g);
    }

    private void drawBackground(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

}