// on intent service
private onGetNotification notify=(onGetNotification)contextOfActivity;

public interface onGetNotification {
    public setOnGetNotification(Boolean result);
}

// use when finish
public void endOfService(){
    notify.setOnGetNotification(true);
}