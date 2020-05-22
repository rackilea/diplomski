public class queueCollection implements java.io.Serializable {
private String QueueName1;

public String getQueueName1() {
    return QueueName1;
}

public void setQueueName1(String queueName1) {
    QueueName1 = queueName1;
}

public String getQueueName2() {
    return QueueName2;
}

public void setQueueName2(String queueName2) {
    QueueName2 = queueName2;
}

public Boolean getAvail() {
    return Avail;
}

public void setAvail(Boolean avail) {
    Avail = avail;
}

private String QueueName2;
private Boolean Avail;

public queueCollection(String queueName1, String queueName2, Boolean avail) {
    this.QueueName1 = queueName1;
    this.QueueName2 = queueName2;
    this.Avail = avail;
}
}