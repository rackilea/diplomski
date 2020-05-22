public interface FormFragmentContract extends WorkshopContractView  {
    void updateWorkshopUI(int icon);
    void showRemoveFavoriteDialog(String wsId, String name);
}

public interface WorkshopListContract extends WorkshopContractView {
    void initializeMap();
    void onSuccessInitMap();
}