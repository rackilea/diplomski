import java.awt.Color
import javax.swing.*
import org.jdesktop.swingx.JXColorSelectionButton

SwingUtilities.invokeAndWait {
@Grapes( 
[@Grab(group='org.swinglabs', module='swingx-core', version='1.6.2-2'),
@Grab(group='com.github.insubstantial', module='substance-swingx', version='7.0') ]
)
    JFrame frame = new JFrame("Test");
    JXColorSelectionButton myColorSelectionButton = new JXColorSelectionButton();

    myColorSelectionButton.setFocusPainted(false);
    frame.add(myColorSelectionButton);
    myColorSelectionButton.setBackground( Color.WHITE );  // Excepton occurres here !!
    frame.pack()
    frame.setVisible(true)
}