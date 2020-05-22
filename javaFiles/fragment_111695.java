cellList.addHandler(new ValueChangeHandler<List<IPost>>() {

        @Override
        public void onValueChange(ValueChangeEvent<List<IPost>> event) {
          //Do something
          //Be careful because this handler could be called from other methods

        }
      }, ValueChangeEvent.getType());