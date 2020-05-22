public interface LocationAware {
    default void changeLocationName(String local) {
        for (International international : getInternationals()) {
            if(local.equals(international.getLanguage())) {
                setName(international.getTranslation());
            }
        }
    }
    String getName();
    void setName(String name);
    List<International> getInternationals();
    void setInternationals(List<International> internationals);
}