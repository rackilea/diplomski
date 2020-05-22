MonadicObservableValue<Boolean> stageFocused = 
            EasyBind.monadic(textFieldForWork.sceneProperty())
                .flatMap(Scene::windowProperty)
                .flatMap(Window::focusedProperty)
                .orElse(false);
    stageFocused.addListener((obs, wasFocused, isNowFocused) -> {
        if (isNowFocused) {
            // stage now has focus...
        } else {
            // stage has lost focus...
        }
    });