private ItemLicense selectedItemLicenseForModification;

...

public void onLicenceChange() {
    selectedItemLicenseForModification = (ItemLicense) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("itemLicense");
}