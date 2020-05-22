import javax.swing.*;

public boolean processRow(StepMetaInterface smi, StepDataInterface sdi) throws KettleException
{

    Object[] r = getRow();
    if (r == null) {
        setOutputDone();
        return false;
    }

    if (first)
    {
        first = false;
        myFrame = new MyFrame();
//      myFrame.setVisible(true);
        JOptionPane.showMessageDialog(myFrame, "Hello world");
        myFrame.dispose();
    }

    return true;
}

private MyFrame myFrame;

private class MyFrame extends JFrame {
    public MyFrame() {
        super();
//      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}