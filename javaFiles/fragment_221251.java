@Service
public class AnnotationConfigTestFrame /* extends JFrame */
{
    public static void main(String[] args) throws InterruptedException
    {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationConfigTestFrame.class);

        AnnotationConfigTestFrame frame = (AnnotationConfigTestFrame) ctx
                .getBean("annotationConfigTestFrame");
//        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        frame.setVisible(true);

        waitABit();
        printRuntimeStats();
        System.exit(0);
    }
}