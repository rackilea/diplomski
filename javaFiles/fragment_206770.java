class AlertService {
    private AlertDAO storage;

    public AlertService(AlertDAO alert) {
        this.storage = alert;
    }

    public UUID raiseAlert() {
        return this.storage.addAlert(new Date());
    }

    public Date getAlertTime(UUID id) {
        return this.storage.getAlert(id);
    }

}