public enum EventStatus {
    PENDING(1), OPEN(2), DISPATCHED(3), APPENDED(4), CLOSED(5), REQUESTED_TO_CLOSE(
            6), ACTION_REQUESTED_FROM_POLICE_STATION(7), ACTION_REQUESTED_FROMD_ISPATCHER(
            8), ACTION_REQUESTED_FROM_SUPERVISOR(9);
    private int value;

    private EventStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    //Just for testing from some SO answers, but no use
    public void setValue(int value) {
        this.value = value;
    }

    public static EventStatus getEventStatusById(int id) {

        EventStatus event = null;

        switch (id) {
        case 1:
            event = PENDING;
            break;
        case 2:
            event = OPEN;
            break;
        case 3:
            event = DISPATCHED; 
            break;
        case 4:
            event = APPENDED;
            break;
        case 5:
            event = CLOSED;
            break;
        case 6:
            event = REQUESTED_TO_CLOSE;
            break;
        case 7:
            event = ACTION_REQUESTED_FROM_POLICE_STATION;
            break;
        case 8:
            event = ACTION_REQUESTED_FROMD_ISPATCHER;
            break;
        case 9:
            event = ACTION_REQUESTED_FROM_SUPERVISOR;
            break;

        default:
            break;
        }
        return event;
    }
}