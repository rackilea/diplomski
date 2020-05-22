public class MyPage extends WebPage {

    IModel<HeavyDataObject> heavyModel;

    @Override
    public void onDetach() {
        if (heavyModel != null)
            heavyModel.detach();
    }

}