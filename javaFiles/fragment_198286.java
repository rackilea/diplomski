import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class MigLayoutTest extends JFrame {
  private JPanel panel;

  private JLabel lblResumenAuto;
  private JLabel lblResumenAutoResult;
  private JLabel lblResumenRazonSocial;
  private JLabel lblResumenRazonSocialResult;
  private JLabel lblResumenPeriodo;
  private JLabel lblResumenPeriodoResult;
  private JLabel lblResumenFechaHora;
  private JLabel lblResumenFechaHoraResult;

  public MigLayoutTest() {
    run();
  }

  public void run() {
    panel = new JPanel();
    panel.setLayout(new MigLayout("debug, fill",
        "[left, 15%]10[left, 35%]10[left, 15%]10[left, 35%]", "[center]10[center]"));

    lblResumenAuto = new JLabel("MY LABEL 1111111111111");
    lblResumenAutoResult = new JLabel("1111111111111111111111");

    panel.add(lblResumenAuto, "sg label");
    panel.add(lblResumenAutoResult, "sg value");

    lblResumenRazonSocial = new JLabel("MY LABEL 2222222222");
    lblResumenRazonSocialResult = new JLabel("2222222222222222222222");

    panel.add(lblResumenRazonSocial, "sg label");
    panel.add(lblResumenRazonSocialResult, "sg value, wrap");

    lblResumenPeriodo = new JLabel("MY LABEL 33333333333333");
    lblResumenPeriodoResult = new JLabel("3333333333333333333333333333333333333333333333333333333");

    panel.add(lblResumenPeriodo, "sg label");
    panel.add(lblResumenPeriodoResult, "sg value");
    // poner el texto como html puede tener otra linea, porque es muy largo
    lblResumenFechaHora = new JLabel("<html>MY LABEL <br /> 4444444444444444</html>");
    lblResumenFechaHoraResult = new JLabel("4444444444444444444444444");

    panel.add(lblResumenFechaHora, "sg label");
    panel.add(lblResumenFechaHoraResult, "sg value");

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    getContentPane().add(panel);

    pack();
    setVisible(true);
    setLocationRelativeTo(null);
    setResizable(true);
  }

  public static void main(String[] args) {
    MigLayoutTest test = new MigLayoutTest();
  }

}