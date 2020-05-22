public class PreferencesDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Language> languages = new ArrayList<Language>(0);

    public List<Language> getLanguages() {return languages;}
    public void setLanguages(List<Language> languages) {this.languages = languages;}
}