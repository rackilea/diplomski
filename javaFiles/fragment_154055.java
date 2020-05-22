@ManagedBean
@ViewScoped
public class MrBean {
    private DataModel<CustomCriteres> customModel;

    public DataModel<CustomCriteres> getCustomModel() {
        /* This is where you would get both `Criteres` and ALL of the related 
          `Appreciation` objects at the same time and put them in 1 single 
           instance of `CustomCriteres` object */ 
    }
}