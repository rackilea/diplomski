ObservableList<WrapperClass>  WrapperObjectList = FXCollections.observableArrayList(
     new Callback<WrapperClass, Observable[]>() {
          @Override
          public Observable[] call(WrapperClass param) {
               return new Observable[] {
                    param.observableValue()
                };
          }
     }
);