finalize.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent ae){
        // snip
        // snap
        double sum = mon + tues + wed + thurs + fri + sat + sun;
        finalBox.setText(Double.toString(sum));
    }
});