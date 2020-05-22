//Inside MyActivity
ViewModelProvider.Factory factory = new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new MyAndroidViewModel(getApplication(),
                        "My string!");
            }
        };