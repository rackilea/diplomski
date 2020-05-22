public interface LocationAware {
    String getName();
    void setName(String name);
    List<International> getInternationals();
    void setInternationals(List<International> internationals);
}