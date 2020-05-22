public MyStoreFilter(String f)  {
    filtro=f;
    setAutoValidate(true);
    setValidateOnBlur(false);
    setTriggerStyle("x-form-clear-trigger");
    filter = new StoreFilter<M>() {
      public boolean select(Store<M> store, M parent, M model, String property) {
        String v = filtro;
        return doSelect(store, parent, model, property, v);
      }
    };
}