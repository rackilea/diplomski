private boolean updating ;

// ...

num1.addListener((obs, oldValue, newValue) -> {
    if (! updating) {
        updating = true ;
        num2.set(-newValue);
        updating = false ;
    }
});

num2.addListener((obs, oldValue, newValue) -> {
    if (! updating) {
        updating = true ;
        num1.set(-newValue);
        updating = false ;
    }
});