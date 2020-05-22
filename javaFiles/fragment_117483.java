public interface LocationAware {
    default String getName() {
        return getInternationals().get(getLocal());
    }
    void setName(String local);
    String getLocal();
    void setLocal(String local);
    Map<String, International> getInternationals();
    void setInternationals(Map<String, International> internationals);
}