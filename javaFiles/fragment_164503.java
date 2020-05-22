Timer myTimer = new Timer(1000, new ActionListener(){
@Override
public void actionPerformed(ActionEvent e) {
    powermessage.setText("myvaluegoeshere");
    }
});
myTimer.start();