@Transacational(isolation=REPEATABLE_READ)
public void toggleSwitch() {
    String status = readSwithStatus();
    if(status.equals("on") {
         updateStatus("off");
    } else {
         updateStatus("on");
    }
}