public void actionPerformed(ActionEvent e) {
    timeout--;
    if(timeout>=1){
        status1.setText("Time out: " + timeout);
    }else{
        patient1.setText("Patient: ");
        status1.setText("Status: Available");
        doctor.get(0).setStatus(true);
        countDoc++;
        setDoc.setText(avDoc + countDoc);
        timeout = 24;

        ((timer) e.getSource()).stop();
    }
}