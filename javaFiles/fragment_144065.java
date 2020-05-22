@Data
@NoArgsConstructor
public class Modality {

    private BigInteger id;
    private String name;
    private String typecompmod;
    private Float typedim;
    private Float tempsplaytex;
    private String typemodetiqu;
    private String preparation;
    private String comment;

    // this custom constructor is what you need
    public Modality(String name, String typecompmod, Float typedim, Float tempsplaytex, String typemodetiqu, String preparation, String comment) {
        this.name = name;
        this.typecompmod = typecompmod;
        this.typedim = typedim;
        this.tempsplaytex = tempsplaytex;
        this.typemodetiqu = typemodetiqu;
        this.preparation = preparation;
        this.comment = comment;
    }
}