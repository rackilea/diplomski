public class Work extends JFrame {

    // ...

    private Time timeObject;

    public Work() {

        // ...

        timeObject = new Time();
        timeObject.SelectTime();
        buttontime2 selectDest = new buttontime2();
        timeObject.getAirportBox().addActionListener(selectDest);

    }

    public class buttontime implements ActionListener {
        public void actionPerformed(ActionEvent clickTime)  {
            // use timeObject, don't create it and don't call SelectTime()
            // example:
            add(timeObject.getTimePanel(),BorderLayout.EAST);
            // ....
        }
    }

    public class buttontime2 implements ActionListener {
        public void actionPerformed(ActionEvent clickTime)  {
            // use timeObject, don't create it and don't call SelectTime()

        }
    }
}