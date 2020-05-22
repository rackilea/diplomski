items.addListener((observable, oldValue, newValue)-> {
    if (newValue == null) {
         disabled.unbind();
         disabled.set(true);
    } else {
         disabled.bind(Bindings.isEmpty(newValue));
    }
});