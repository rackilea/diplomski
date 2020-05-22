getYourListObservable() 
    .filter(new Predicate<ViewModel>() {
            @Override
            public boolean test(@NonNull ViewModel viewModel) throws Exception {
                return !TextUtils.isEmpty(viewHolder);
            }
        })
    .subscribe(...) // this is where you pass data to your RecyclerView.Adapter object