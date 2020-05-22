import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class TestJTextArea2 {
  public Component makeUI() {
    String text = "The quick brown fox jumps over the lazy dog.";
    JTextArea textArea1 = new JTextArea("default\n" + text);
    JTextArea textArea2 = new JTextArea("setCaret\n" + text) {
      @Override public void updateUI() {
        setCaret(null);
        super.updateUI();
        Caret oldCaret = getCaret();
        int blinkRate = oldCaret.getBlinkRate();
        Caret caret = new SelectWordCaret();
        caret.setBlinkRate(blinkRate);
        setCaret(caret);
      }
    };
    JPanel p = new JPanel(new GridLayout(2, 1));
    p.add(new JScrollPane(textArea1));
    p.add(new JScrollPane(textArea2));
    return p;
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new TestJTextArea2().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}

class SelectWordCaret extends DefaultCaret {
  private boolean wordSelectingMode = false;
  private int p0; // = Math.min(getDot(), getMark());
  private int p1; // = Math.max(getDot(), getMark());

  @Override public void mousePressed(MouseEvent e) {
    super.mousePressed(e);
    int nclicks = e.getClickCount();
    if (SwingUtilities.isLeftMouseButton(e) && !e.isConsumed() && nclicks == 2) {
      p0 = Math.min(getDot(), getMark());
      p1 = Math.max(getDot(), getMark());
      wordSelectingMode = true;
    } else {
      wordSelectingMode = false;
    }
  }

  @Override public void mouseDragged(MouseEvent e) {
    if (wordSelectingMode && !e.isConsumed() && SwingUtilities.isLeftMouseButton(e)) {
      continuouslySelectWords(e);
    } else {
      super.mouseDragged(e);
    }
  }

  private void continuouslySelectWords(MouseEvent e) {
    Position.Bias[] biasRet = new Position.Bias[1];
    JTextComponent c = getComponent();
    int pos = c.getUI().viewToModel2D(c, e.getPoint(), biasRet);
    if(biasRet[0] == null) {
      biasRet[0] = Position.Bias.Forward;
    }
    try {
      if (p0 <= pos && pos <= p1) {
        setDot(p0);
        moveDot(p1, biasRet[0]);
      } else if (p1 < pos) {
        setDot(p0);
        moveDot(Utilities.getWordEnd(c, pos - 1), biasRet[0]);
      } else if (p0 > pos) {
        setDot(p1);
        moveDot(Utilities.getWordStart(c, pos), biasRet[0]);
      }
    } catch (BadLocationException bl) {
      UIManager.getLookAndFeel().provideErrorFeedback(c);
    }
  }
}