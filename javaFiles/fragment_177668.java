import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;
import javax.swing.JFileChooser;

public class PickSomething implements ActionListener {
    private Consumer<String> consumer;

    public PickSomething(Consumer<String> consumer) {
        this.consumer = consumer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser selectElement = new JFileChooser();
        String path;
        int status = selectElement.showOpenDialog(null);

        if (status == JFileChooser.APPROVE_OPTION) {
            path = selectElement.getSelectedFile().getAbsolutePath();
        } else {
            path = null;
        }
        consumer.accept(path);
    }
}