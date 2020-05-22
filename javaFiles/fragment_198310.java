import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mock;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(JOptionPane.class)
@SuppressStaticInitializationFor("javax.swing.text.JTextComponent")
public class PowerMockIssue {
    @Test
    public void powermockTest() {
        final JTextArea textArea = mock(JTextArea.class);
        when(textArea.getText()).thenReturn("test");
        Assert.assertEquals("test", textArea.getText());
    }
}