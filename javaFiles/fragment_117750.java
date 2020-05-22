public class JsonResponse {

@SerializedName("worldpopulation")
@Expose
private List<Worldpopulation> worldpopulation = null;

public List<Worldpopulation> getWorldpopulation() {
return worldpopulation;
}

public void setWorldpopulation(List<Worldpopulation> worldpopulation) {
this.worldpopulation = worldpopulation;
}

}