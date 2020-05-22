public Single<Optional<Model>> getMyModel(boolean offlineFallback) {

    return apiInterface.getModel()
            .map( model -> {
                if( model.isPresent() ){

                    MyModel serverMyModel = model.get();
                    MyModel savedMyModel = databaseRepository.getMyModel();
                    if( serverMyModel != savedMyModel ){
                        serverMyModel.setMyAttribute(true);
                        databaseRepository.saveMyModel( serverMyModel );
                    }
                    return java8.util.Optional.ofNullable( serverMyModel );

                }else{

                    if(offlineFallback){
                        MyModel MyModel = databaseRepository.getMyModel();
                        if(MyModel != null){
                            return java8.util.Optional.ofNullable(MyModel);
                        }
                    }
                    return Optional.empty();

                }
            });
}