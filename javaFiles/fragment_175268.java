@XStreamAlias("coin")
public class Coin {
    @XStreamAsAttribute
    String type;

    Coin(String type) {
        this.type = type;
    }
}