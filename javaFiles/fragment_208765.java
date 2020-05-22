public class FacebookResponses implements Serializable {

private static final long serialVersionUID = 1L;

@SerializedName("data")
public FacebookRisp[] data;

public FacebookRisp[] getData() {
    return data;
}

public void setData(FacebookRisp[] data) {
    this.data = data;
}

@Override
public String toString() {
    return "FacebookResponses [data=" + Arrays.toString(data) + "]";
}
}