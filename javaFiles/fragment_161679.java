private class PBTask extends SwingWorker<Void, UpdatePB> {
    @Override
    protected Void doInBackground() {
        int prog1 = 0;
        int prog2 = 0;
        Random random = new Random();

        while (prog2 < 100) {
            if(prog1 >= 100) {
                prog1 = 0;
            }
            //Sleep for up to one second.
            try {
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException ignore) {}
            //Make random progress.
            prog1 += random.nextInt(10);
            prog2 += random.nextInt(5);
            publish(new UpdatePB(prog1, prog2));
        }
        return null;
    }

    @Override
    protected void process(List<UpdatePB> pairs) {
        UpdatePB pair = pairs.get(pairs.size() - 1);
            pb.setValue(pair.pb1);
            pbF.setValue(pair.pb2);
    }

    @Override
    protected void done() {
        super.done();
        theButton.setText("Start");
        theButton.setActionCommand("Start");
    }
}