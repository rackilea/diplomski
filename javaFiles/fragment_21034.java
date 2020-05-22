public class MenuBean {
    private SelectItem[] familyNames = {
            new SelectItem(1, "Operations"),
            new SelectItem(2, "Special"),
            new SelectItem(3, "Support")};

    public SelectItem[] getFamilyNames() {
        return familyNames;
    }

    private SelectItem[] functions = {new SelectItem("Select Function")};

    private SelectItem[] operationsFunctions = {
            new SelectItem("Air/Ocean Freight"),
            new SelectItem("Customs"),
            new SelectItem("Land Transport"),
            new SelectItem("Logistics/SCM"),
            new SelectItem("Rail Transport"),
            new SelectItem("Special")
    };

    private SelectItem[] specialFunctions = {
            new SelectItem("General Management"),
            new SelectItem("Quality & Processes")
    };

    private SelectItem[] supportFunctions = {
            new SelectItem("Finance/Controlling"),
            new SelectItem("Human Resources"),
            new SelectItem("ICT"),
            new SelectItem("Legal Affairs"),
            new SelectItem("Marketing/Public Relations"),
            new SelectItem("Procurement"),
    };

    public SelectItem[] getFunctions() {
        return functions;
    }

    private void switchSelectedFunctions(int n) {
        if (n == 1) {
            setFunctions(operationsFunctions);
        } else if (n == 2) {
            setFunctions(specialFunctions);
        } else if (n == 3) {
            setFunctions(supportFunctions);
        }
    }

    public void setFunctions(SelectItem[] function) {
        this.functions = function;
    }

    public void changeFamily(ValueChangeEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        int value = Integer.valueOf(((String) event.getNewValue()));
        switchSelectedFunctions(value);
        context.renderResponse();
    }
}