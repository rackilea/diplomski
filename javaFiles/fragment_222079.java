import javax.inject.Inject;

public class ModuleOne implements Module {

    @Inject
    private ModuleConfiguration moduleConfiguration;

    @Inject
    ModuleTwo moduleTwo;

    public String getName() {
        return "moduleOne name";
    }
}