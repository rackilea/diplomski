import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class Background extends SwingWorker<Void, Void>{

    @Override
    protected void done(){
            //JOptionPane.showMessageDialog(null,"Process Done Successfully...","Successfull",JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    protected Void doInBackground() throws Exception {
        //Write your code here
        return null;    
    }
}