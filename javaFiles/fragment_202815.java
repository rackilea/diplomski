ObservableList<WrapperClass>  WrapperObjectList = FXCollections.observableArrayList(
     new Callback<WrapperClass, Observable[]>() {
          @Override
          public Observable[] call(WrapperClass param) {
               if (param.getControl() instanceof Spinner) {
                   return new Observable[] {
                       ((Spinner) param.getControl()).valueProperty()
                   };
               } else if (param.getControl() instanceof CheckBox) {
                   return new Observable[] {
                       ((CheckBox) param.getControl()).selectedProperty()
                   };
               } else return new Observable[0] ;
          }
     }
);