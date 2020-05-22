@Root(name = "INVAP-WS-ASSETSet", strict=false)
public class INVAPWSASSETSet {

    @ElementList(inline=true, name = "ASSET")
    private List<Activo> activos;
}