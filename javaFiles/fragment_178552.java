private void populateList(String filter) {
            temp = mDbHelper.fetchSugNotes(filter);


        temp.moveToFirst();
        this.startManagingCursor(temp);
        groupDataCat = new ArrayList<Map<String, String>>();
        childDataCat = new ArrayList<List<Map<String, String>>>();

        for (int i = 0; i < temp.getCount(); i++) {
            Map<String, String> catGroupMap = new HashMap<String, String>();
            groupDataCat.add(catGroupMap);
            catGroupMap.put(WORD, temp.getString(temp
                    .getColumnIndexOrThrow(DbAdapter.KEY_WORD)));

            List<Map<String, String>> meaning = new ArrayList<Map<String, String>>();
            Map<String, String> catChildMap = new HashMap<String, String>();
            meaning.add(catChildMap);
            catChildMap.put(MEANING, temp.getString(temp
                    .getColumnIndexOrThrow(DbAdapter.KEY_MEANING)));
            childDataCat.add(meaning);
            temp.moveToNext();
        }

        mAdapter = new SimpleExpandableListAdapter(this, groupDataCat,
                R.layout.word_list_item, new String[] { WORD },
                new int[] { R.id.tvWord }, childDataCat,
                R.layout.meaning_list_item, new String[] { MEANING },
                new int[] { R.id.tvMeaning });

        elvCat.setAdapter(mAdapter);