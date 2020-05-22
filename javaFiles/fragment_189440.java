private Data data;

public Data getData() {
    return data;
}

@XmlElement(name="data")
public void setData(Data data) {
    this.data = data;
}