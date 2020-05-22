while (cursor.moveToNext()) {
        final int id = cursor.getInt(cursor.getColumnIndex("id"));
        String name = cursor.getString(cursor.getColumnIndex("name"));

        CheckBox cb = new CheckBox(this);
        cb.setText(name);
        cb.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        yourMethodRequiredId(id, isChecked);
                    }
                });
        layout.addView(cb);
    }