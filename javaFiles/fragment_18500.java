public class Algorithm extends SwingWorker<Void,Integer>{
    //variable declarations
    public Algorithm(MDVRPData data,String fileName, JTextArea jText, boolean method1,
        boolean method2, boolean method3, boolean twoOpt,
        boolean oneOneExc, boolean oneZeroExc, JSpinner iter, final JProgressBar jProgressBar1) {
        iterations=(Integer) iter.getValue();
        jText.setText("");
        jText.append("START ALGORITHM \n");
        jProgressBar1.setStringPainted(true);
        initDrawWindow(fileName);
        dr = new DecodeRoutes(twoOpt,oneOneExc,oneZeroExc);
        this.data=data;
        this.oneOneExc=oneZeroExc;
        this.twoOpt=twoOpt;
        this.oneZeroExc=oneZeroExc;
        this.bar=jProgressBar1;
        doInBackground();
    }  
    @Override
    protected Void doInBackground() {
         //initialization code
        for (int iteration = 0; iteration < iterations; iteration++) {
            publish(iteration);
            //other computations and function calls
        }
        //function calls
        return null;
    }  
@Override
protected void process(List<Integer> iter) {
    int iteration = iter.get(iter.size() - 1);
    int procent = (int) (((iteration + 1.) / iterations) * 100);
    bar.setValue(procent);
    bar.setString(procent + "%");
}