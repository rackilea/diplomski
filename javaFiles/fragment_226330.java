mDiaryViewModel.getmEntriesMonth(month).observe(getViewLifecycle(), new 
             Observer<List<Diary>>() {
    @Override
    public void onChanged(List<Diary> diaries) {
        adapter.setEntries(diaries);
    }
});