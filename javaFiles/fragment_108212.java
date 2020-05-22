@ManagedBean
@ViewScoped
public class CreateResourceDialogController {

    private List<SelectItem> options;

    private String selectedDirId;

    private void initBean(){
        options = new ArrayList<SelectItem>();
        SelectItem item1 = new SelectItem(dir.getId.toString(), dir.getName());
        options.add(item1);
    }

    public List<SelectItem> getOptions(){
        return options;
    }

    public void setSelectedDirId(String dirId){
        selectedDirId = dirId;
    }

    public String getSelectedDirId(){
        return selectedDirId;
    }
}