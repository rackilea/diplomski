import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.*;
import javax.swing.*;

public class MainClass {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            final Frame2 frame = new Frame2();
            frame.setVisible(true);
            final ArrayObject2d array = new ArrayObject2d(10, 5);

            frame.addPropertyChangeListener(Frame2.FRAME_STATE, propChngEvent -> {
                if (frame.getFrameState() == 1) {
                    array.setRandom(100);
                    array.print();
                } else if (frame.getFrameState() == 2) {
                    array.setAll(99999);
                    array.print();
                } else if (frame.getFrameState() == 3) {
                    array.numberAll();
                    array.print();
                } else if (frame.getFrameState() == 4) {
                    array.showIndex();
                }
            });
        });
    }
}