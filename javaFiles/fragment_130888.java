public class MyFrame(){

        SpinnerModel spinnerModel = new SpinnerNumberModel(0,0,999,1);
        JSpinner anlist = new JSpinner(spinnerModel);
        JPanel panel1 = new JPanel();

        public MyFrame(){

                 panel1.add(anlist);

                        }

}