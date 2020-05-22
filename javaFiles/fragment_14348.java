import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.Clock;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

class ClipPlayer implements LineListener {

    private final AtomicBoolean playable;
    private final AtomicBoolean done;
    private final Optional<AudioInputStream> stream;
    private final Optional<Clip> clip;

    public ClipPlayer(String fileName) {

        playable = new AtomicBoolean(false);
        done = new AtomicBoolean(false);
        File source = new File(fileName);
        boolean proceed = source.exists();
        stream = createAudioInputStream(source, proceed);
        if (stream == Optional.<AudioInputStream>empty()) {
            proceed = false;
        }
        clip = createClip(stream.get(), proceed);
        if (clip == Optional.<Clip>empty()) {
            proceed = false;
        }

        playable.set(proceed);
    }

    private Optional<Clip> createClip(AudioInputStream stream, boolean proceed) {
        if (!proceed) {
            return Optional.empty();
        }
        AudioFormat format = stream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class,format);
        try {
            Clip clip = (Clip)AudioSystem.getLine(info);
            clip.addLineListener(this);
            return Optional.of(clip);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return Optional.empty();
        }
    }

    private static Optional<AudioInputStream> createAudioInputStream(File source, boolean proceed) {
        if (!proceed) {
            return Optional.empty();
        }
        try {
            AudioInputStream stream = AudioSystem.getAudioInputStream(source);
            Optional<AudioInputStream> optionalStream = Optional.ofNullable(stream);
            return optionalStream;
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return Optional.empty();
        }
    }

    public void close() {

        try {
            if (clip.isPresent()) {
                clip.get().close();
            }
            if (stream.isPresent()) {
                stream.get().close();
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            System.exit(1);
        }

    }

    public void open() {

        if (playable.get()) {
            try {
                clip.get().open(stream.get());
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
                System.exit(1);
            }
        } else {
            System.out.println("The file cannot be played.");
        }

    }

    public void play() {

        if (playable.get() && !done.get()) {
            try {
                clip.start();
                while (!done.get()) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println("Exception: " + e.getMessage());
                        System.exit(1);
                    }
                }
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
                System.exit(1);
            }
        } else if (!playable.get()) {
            System.out.println("The file cannot be played.");
        } else if (done.get()) {
            System.out.println("The player must be reset before it can be played again.");
        }

    }

    public void repeat(int n) {

        for (int i = 0; i < n; i++) {
            play();
            reset();
        }

    }

    public void reset() {

        done.set(false);
        if (clip.isPresent()) {
            clip.get().setFramePosition(0);
        }

    }

    @Override
    public void update(LineEvent event) {
        if (event.getType() == LineEvent.Type.STOP) {
            done.set(true);
        }
    }

}


class Timer extends JPanel implements ActionListener {

    private static final int MILLISECONDS_PER_SECOND = 1000;
    private static final int MILLISECONDS_PER_MINUTE = 60*MILLISECONDS_PER_SECOND;
    private static final int MILLISECONDS_PER_HOUR   = 60*MILLISECONDS_PER_MINUTE;

    private static final int HOURS   = 0;
    private static final int MINUTES = 1;
    private static final int SECONDS = 2;
    private static final int RESET   = 0;
    private static final int PAUSE   = 1;

    private final AtomicLong    timeRemaining;
    private final AtomicBoolean finished;
    private final AtomicBoolean paused;
    private final JSpinner[]    spinners;
    private final JButton[]     buttons;
    private final JLabel        remainderLabel;
    private final ClipPlayer    player;

    public Timer() {

        this.timeRemaining = new AtomicLong(0L);
        this.finished = new AtomicBoolean(true);
        paused = new AtomicBoolean(true);
        player = new ClipPlayer("/example/path/file.wav");
        spinners = new JSpinner[3];
        spinners[HOURS] = new JSpinner(new SpinnerNumberModel(0,0,99,1));
        spinners[MINUTES] = new JSpinner(new SpinnerNumberModel(0,0,60,1));
        spinners[SECONDS] = new JSpinner(new SpinnerNumberModel(0,0,60,1));
        buttons = new JButton[2];
        buttons[RESET] = new JButton("Begin");
        buttons[PAUSE] = new JButton("Pause");
        buttons[PAUSE].setEnabled(false);
        for (int i = 0; i < 2; i++) {
            buttons[i].addActionListener(this);
            buttons[i].setActionCommand("Button_" + i);
        }
        remainderLabel = new JLabel();

        // Layout code omitted for brevity

    }

    // actionPerformed method omitted for brevity

    public void initialize() {

        Object h = spinners[HOURS].getValue();
        Object m = spinners[MINUTES].getValue();
        Object s = spinners[SECONDS].getValue();
        timeRemaining.set(((Integer)h)*MILLISECONDS_PER_HOUR);
        timeRemaining.addAndGet(((Integer)m)*MILLISECONDS_PER_MINUTE);
        timeRemaining.addAndGet(((Integer)s)*MILLISECONDS_PER_SECOND);
        if (timeRemaining.get() > 0) {
            this.finished.set(false);
            paused.set(false);
            buttons[RESET].setText("Reset");
            buttons[PAUSE].setEnabled(true);
        } else {
            this.finished.set(true);
            paused.set(false);
        }

    }

    public void update(long dt) {

        if (!finished.get() && !paused.get()) {
            timeRemaining.addAndGet(-1 * dt);
            if (timeRemaining.get() > 0) {
                long hours = timeRemaining.get()/MILLISECONDS_PER_HOUR;
                long r = timeRemaining.get() - hours*MILLISECONDS_PER_HOUR;
                long minutes = r/MILLISECONDS_PER_MINUTE;
                r -= minutes*MILLISECONDS_PER_MINUTE;
                long seconds = r/MILLISECONDS_PER_SECOND;
                StringBuilder sb = new StringBuilder();
                sb.append(hours);
                sb.append(":");
                if (minutes < 10) sb.append("0");
                sb.append(minutes);
                sb.append(":");
                if (seconds < 10) sb.append("0");
                sb.append(seconds);
                remainderLabel.setText(sb.toString());
            } else {
                finished.set(true);
                buttons[RESET].setText("Begin");
                buttons[PAUSE].setEnabled(false);
                remainderLabel.setText("0:00:00");
                System.out.println("Time's up!");
                player.open();
                player.repeat(3);
                player.close();
            }
        }

    }

}

public class Time implements Runnable {

    private final JFrame frame;
    private final Clock clock;
    private final Timer timer;

    // Constructor and main method omitted for brevity

    public void run() {

        long t0 = System.currentTimeMillis();
        boolean running = true;
        while (running) {
            long t1 = System.currentTimeMillis();
            clock.update(t1);
            timer.update(t1-t0);
            t0 = t1;
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                System.out.println("Interrupted Exception: " + ie.getMessage());
                System.exit(1);
            }
        }
        System.exit(0);

    }

}