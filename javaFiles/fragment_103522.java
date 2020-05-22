class TunerListener implements ActionListener {

private TunerWorker tw = null;

@Override
public void actionPerformed(ActionEvent ae) {

    if (ae.getActionCommand().equals("tune")) {
        if (tw == null || tw.isDone()) {
            tune.setText("Stop Tuning");
            executing = true;

            tw = new TunerWorker();
            tw.execute();

        } else {
            tune.setText("Start Tuning");
            executing = false;
            tw.cancel(true);
            }
        }
    }
}

final class TunerWorker extends SwingWorker<Void, Void> {

    @Override
    protected Void doInBackground() {
        while (!this.isCancelled()) {
            model.update();
        }        
        return null;
    }    

    @Override
    protected void done() {
        if (!this.isCancelled()) {
            //Removed this code to make the example prettier...
        }
    }
}