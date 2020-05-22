public class TestFrame extends JFrame {

    public TestFrame () {
        super ("testframe");
        setSize (400, 400);
        setVisible (true);
    }

    public static void main (String [] args)
    {
        InstructorEditorPanel iep = new InstructorEditorPanel ();
        TestFrame tf = new TestFrame ();
        tf.add (iep);
        iep.setFieldText (InstructorEditorPanel.FieldTitle.FIRST_NAME, "Donald");
    }
}