public class DirectionMatrixResult {
    private String[] destination_addresses;
    private String[] origin_addresses;

    private DirectionMatrixResultRow[] rows;

    public DirectionMatrixResultRow[] getRows() {
        return rows;
    }

    public String[] getDestination_addresses() {
        return destination_addresses;
    }

    public String[] getOrigin_addresses() {
        return origin_addresses;
    }

    public void setDestination_addresses(String[] destination_addresses) {
        this.destination_addresses = destination_addresses;
    }

    public void setOrigin_addresses(String[] origin_addresses) {
        this.origin_addresses = origin_addresses;
    }

    public void setRows(DirectionMatrixResultRow[] rows) {
        this.rows = rows;
    }
}

public class DirectionMatrixResultRow {
    private DirectionMatrixResultElement[] elements;

    public DirectionMatrixResultElement[] getElements() {
        return elements;
    }

    public void setElements(DirectionMatrixResultElement[] elements) {
        this.elements = elements;
    }
}

public class DirectionMatrixResultElement {
    private DirectionMatrixResultElementValue distance;
    private DirectionMatrixResultElementValue duration;
    private String status;

    public DirectionMatrixResultElementValue getDistance() {
        return distance;
    }

    public DirectionMatrixResultElementValue getDuration() {
        return duration;
    }

    public String getStatus() {
        return status;
    }

    public void setDistance(DirectionMatrixResultElementValue distance) {
        this.distance = distance;
    }

    public void setDuration(DirectionMatrixResultElementValue duration) {
        this.duration = duration;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

public class DirectionMatrixResultElementValue {
    private String text;
    private long value;

    public long getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setValue(long value) {
        this.value = value;
    }
}