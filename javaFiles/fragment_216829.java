/**
 * 
 * @author ggrec
 *
 */
public class AnotherShell
{

    // ==================== 2. Instance Fields ============================

    private Shell shell;


    // ==================== 4. Constructors ===============================

    public AnotherShell()
    {
        shell = new Shell(Display.getCurrent());
    }


    // ==================== 6. Action Methods =============================

    public void open()
    {
        shell.open();
    }

    public void close()
    {
               // Don't call shell.close(), because then
               // you'll have to re-create it
        shell.setVisible(false);
    }
}