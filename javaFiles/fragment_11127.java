@Override
public void loadData(){
    mModel.loadData(new Callback{
        void onSuccess(){
            getView().notifyDataLoaded();
        }

        void onError(){
            getView().notifyErrorOccured();
        }
});