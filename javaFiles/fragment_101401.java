public class Demon {

    @SerializedName("ailments")
    @Expose
    public String ailments;

    @SerializedName("align")
    @Expose
    public String align;

    @SerializedName("code")
    @Expose
    public Integer code;

    @SerializedName("inherits")
    @Expose
    public String inherits;

    @SerializedName("lvl")
    @Expose
    public Integer lvl;

    @SerializedName("pcoeff")
    @Expose
    public Integer pcoeff;

    @SerializedName("race")
    @Expose
    public String race;

    @SerializedName("resists")
    @Expose
    public String resists;

    @SerializedName("skills")
    @Expose
    public List<String> skills = null;

    @SerializedName("source")
    @Expose
    public List<String> source = null;

    @SerializedName("stats")
    @Expose
    public List<Integer> stats = null;

    public Demon(){
        // Default constructor
    }
}