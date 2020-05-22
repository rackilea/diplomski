public class ProgressView {

private static ProgressHandlerImpl progressHandler = new ProgressHandlerImpl(); 

private JComponent view = null;

public static ProgressHandler getProgressHandler(){
    return progressHandler;
}

public JComponent getView(){
    if (view == null) view = createView();
    return view;
}

private JComponent createView(){
    JPanel result = new JPanel( new BorderLayout() );        
    result.add( progressHandler.getMessageLabel(), BorderLayout.NORTH );
    result.add( progressHandler.getProgressBar(), BorderLayout.CENTER );
    return result;
}

private static class ProgressHandlerImpl implements ProgressHandler{
    public JProgressBar progressBar = null;
    public JLabel messageLabel = null;

    public ProgressHandlerImpl(){
        progressBar = new JProgressBar();
        progressBar.setVisible(false);
        progressBar.setStringPainted(true);

        messageLabel = new JLabel();
        messageLabel.setVisible(false);
    }

    public JProgressBar getProgressBar(){
        return progressBar;
    }

    public JLabel getMessageLabel(){
        return messageLabel;
    }

    @Override
    public void startProgress(){
        java.awt.EventQueue.invokeLater( new Runnable(){ public void run(){
        progressBar.setValue(0);
        progressBar.setVisible(true); } } );            
    }

    @Override
    public void updateProgress(String message, int progress) {
        java.awt.EventQueue.invokeLater( new Runnable(){  public void run(){
        progressBar.setValue(progress); 

        if (message == null) return;

        if ( !messageLabel.isVisible() ) messageLabel.setVisible(true);

        messageLabel.setText(message);
        } } );  
    }

    @Override
    public void stopProgress(){
        java.awt.EventQueue.invokeLater( new Runnable(){  public void run(){
        progressBar.setValue(0);
        progressBar.setVisible(false); 
        messageLabel.setVisible(false);} } );  
    }       
}