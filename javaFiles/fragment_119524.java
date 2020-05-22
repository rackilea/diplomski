public class TestPojo {
    private Outbound outbound;

    public Outbound getOutbound() {
        return outbound;
    }

    public void setOutbound(Outbound outbound) {
        this.outbound = outbound;
    }

}

class Outbound {
    private String[] address;
    private String send;
    private OutMessage outMessage;
    private Receipt receipt;
    private String senderName;

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    public String getSend() {
        return send;
    }

    public void setSend(String send) {
        this.send = send;
    }

    public OutMessage getOutMessage() {
        return outMessage;
    }

    public void setOutMessage(OutMessage outMessage) {
        this.outMessage = outMessage;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

}

class OutMessage {
    private String message;

    public OutMessage(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

class Receipt {
    private String URL;
    private String callback;

    public Receipt(String uRL, String callback) {
        super();
        URL = uRL;
        this.callback = callback;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String uRL) {
        URL = uRL;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

}