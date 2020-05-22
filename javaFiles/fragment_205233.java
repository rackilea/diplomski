public class LoadDataView {
private JComponent view = null;
private Thread thread = null;

public JComponent getView(){
    if (view == null) view = createView();
    return view;
}

private JComponent createView(){
    JPanel result = new JPanel();

    JButton startProgressButton = new JButton("start");
    startProgressButton.addActionListener( new ActionListener() { public void actionPerformed(ActionEvent e) { startProgress(); } } );        
    result.add(startProgressButton);

    JButton stopProgressButton = new JButton("stop");
    stopProgressButton.addActionListener( new ActionListener() { public void actionPerformed(ActionEvent e) { stopProgress(); } } );        
    result.add(stopProgressButton);

    return result;
}

private void startProgress(){
    if (thread != null) throw new IllegalStateException();

    thread = new Thread( new Runnable(){ public void run(){
        ProgressView.getProgressHandler().startProgress();

        for (int i = 0; i < 100; i++){
            ProgressView.getProgressHandler().updateProgress("Loading...", i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {                   
                ProgressView.getProgressHandler().updateProgress("Loading stopped!", i);
                //do some other logging
                break;
            }
        }

    } } );

    thread.start();
}

private void stopProgress(){
    if (thread == null) return;

    thread.interrupt(); 

    thread = null;
}