private void setupViewModel() {
        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        final LiveData<List<JournalEntry>> liveItems = viewModel.getJournals();
        final MediatorLiveData itemListData = new MediatorLiveData<>();
        itemListData.addSource(liveItems, new Observer<List<JournalEntry>>() {
            @Override public void onChanged(List<JournalEntry> journalEntries) {
                Map<Date, List<JournalEntry>> journals = toMap(journalEntries);
                Date previousDate = null;
                items.clear();
                for (Date date : journals.keySet()) {
                    HeaderItem header = new HeaderItem(date);
                    Date currentDate = header.getDate();
                    if (previousDate == null || !DateUtil.formatDate(currentDate).equals(DateUtil.formatDate(previousDate))) {
                        items.add(header);
                    }

                    for (JournalEntry journal : journals.get(date)) {
                        JournalItem item = new JournalItem(journal);
                        items.add(item);
                        previousDate = item.getJournalItem().getCreatedAt();
                    }
                }
                itemListData.setValue(items);


            }
        });

        itemListData.observe(this, new Observer<List<ListItem>>() {
            @Override
            public void onChanged(@Nullable List<ListItem> journalEntries) {
                Log.d(TAG, "Updating list of tasks from LiveData in ViewModel");
                mAdapter.setItems(journalEntries);
            }
        });


    }