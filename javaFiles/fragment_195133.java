private List<SelectItem> paymentMethods; // +getter

public Bean() {
    paymentMethods = new ArrayList<SelectItem>();
    ResourceBundle bundle = ResourceBundle.getBundle("com.example.Messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());

    if (condition) {
        paymentMethods.add(new SelectItem("online", bundle.getString("payment.online.lbl")));
    }

    // ...
}