mListNotes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            deleteButtonIn();
            na.showCheckBox(position);
            return true;
        }
    });
    Checkbox  universalCheckBox = findViewById(R.id.check_all);
    universalCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            na.checkboxAllChange(buttonView.isChecked());
        }
    });