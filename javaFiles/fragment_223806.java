interface Observer<T>{
    public void update (T o);
}

interface DialogBoxAuthenticateObserver extends Observer<DialogBoxAuthenticate>{
}