@Data
public class Hoge {

    @JsonProperty("id")
    public final int cid;

    @JsonCreator
    public Hoge(int id){
        this.cid = id;
    }
}