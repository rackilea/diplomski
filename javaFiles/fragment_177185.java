import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Race {

    /** Distance of race in pixels */
    private double      distance;

    private long        elapsedTime;

    private List<Horse> horses;

    public Race(double distance) {
        this.distance = distance;
        this.horses = new ArrayList<Horse>();
        this.elapsedTime = 0;
    }

    public void init() {
        this.elapsedTime = 0;
        for (Horse horse : horses) {
            horse.init();
        }
    }

    public void addHorse(Horse horse) {
        this.horses.add(horse);
    }

    public int getHorseCount() {
        return horses.size();
    }

    public double getDistance() {
        return distance;
    }

    public void setElapsedTime(long elapsedTime) {
        if (isWinner() == null) {
            this.elapsedTime = elapsedTime;
        }
    }

    public String getElapsedTime() {
        int centiseconds = (int) (((elapsedTime % 1000L) + 5L) / 10L);
        int seconds = (int) (elapsedTime / 1000L);
        if (seconds < 60) {
            return String.format("%2d.%02d", seconds, centiseconds);
        } else {
            int minutes = seconds / 60;
            seconds -= minutes * 60;
            return String.format("%2d:%02d.%02d", minutes, seconds,
                    centiseconds);
        }
    }

    public int getTrackWidth() {
        return (int) Math.round(getDistance()) + 100;
    }

    public int getTrackHeight() {
        return getHorseCount() * Horse.POSITION + Horse.MARGIN;
    }

    public void setHorseVelocity() {
        for (Horse horse : horses) {
            horse.setVelocity();
        }
    }

    public void updateHorsePositions(int milliseconds) {
        for (Horse horse : horses) {
            horse.moveHorse(milliseconds);
        }
    }

    public Horse isWinner() {
        for (Horse horse : horses) {
            if ((distance - Horse.RADIUS) <= horse.getDistance()) {
                return horse;
            }
        }

        return null;
    }

    public boolean allHorsesRunning() {
        for (Horse horse : horses) {
            if ((distance + Horse.RADIUS + 6) > horse.getDistance()) {
                return true;
            }
        }

        return false;
    }

    public void draw(Graphics g) {
        drawLine(g, Horse.POSITION, 6);
        drawLine(g, (int) Math.round(getDistance()) + Horse.RADIUS
                + Horse.MARGIN, 6);

        for (Horse horse : horses) {
            horse.draw(g);
        }
    }

    private void drawLine(Graphics g, int x, int width) {
        int y = Horse.MARGIN;
        int height = getHorseCount() * Horse.POSITION - y;
        g.setColor(Color.BLACK);
        g.fillRect(x, y, width, height);
    }

}