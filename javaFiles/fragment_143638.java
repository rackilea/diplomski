public class DTO implements Serializable {
    private static final long serialVersionUID = -1L;
    private Stress stress;

    public static class Stress implements Serializable {

        private static final long serialVersionUID = 5133888753296054639L;

        private Config fxPOS;

        @JsonGetter("FxPOS")
        public Config getFxPOS() {
            return fxPOS;
        }

        @JsonSetter("FxPOS")
        public void setFxPOS(int fxPOS) {
            this.fxPOS = fxPOS;
        }
    }
}

@Getter
@Setter
@NoArgsConstructor
@JsonSerialize
public class Config implements Serializable {

    private static final long serialVersionUID = -7335939612336666586L;

    private String sx;

    @JsonGetter("SX")
    public String getSx() {
        return sx;
    }

    @JsonSetter("SX")
    public void setRed(int sx) {
        this.sx = sx;
    }
}