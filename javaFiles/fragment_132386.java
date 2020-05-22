stopBtn.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        //your code here
        System.out.println("in actionPerformed: " + stopCatpure);
    }
}

class CaptureThread extends Thread {
    //same code
            while (!stopCapture) {
                System.out.println("in while: " + stopCapture);
                //rest of your code
            }
}