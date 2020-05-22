public class MyWorker extends SwingWorker<Integer, Integer> {
    public Integer doInBackground(){
        // It would be better to have obtained this value before
        // doInBackground is called, but that's just me...
        howMany=Integer.parseInt(textField.getText());
        String result=longMethod(howMany, new ProgressMonitor() {
            public void progressUpdated(double progress) {
                setProgress((int)(progress * 100));
            }
        });
        //label.setText("Hello, you have "+result);
        publish(result);
        return result;
    }

    protected void process(List<Integer> chunks) {
        label.setText("Hello, you have "+chunks.get(chunks.size() - 1));
    }
}