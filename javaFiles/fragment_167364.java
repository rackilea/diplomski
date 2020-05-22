delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int position = (Integer) view.getTag();
                // Access the row position here to get the correct data item
                Preset preset = getItem(position);
                // Do what you want here...
                String presetValue = preset.getValue();
                presetsDBHelper mPresetsDBHelper = new presetsDBHelper(name.getContext());
                mPresetsDBHelper.removeSpecificPreset(presetValue);

                presetList.clear();
                Cursor presets = mPresetsDBHelper.getSpecificPresets("Environment"); //Didn't work with getPassedPresetVariable, attempted hardcoded value to test. Still not functional
                try {
                    if (presets.moveToNext()) {
                        do {
                            presetList.add(new Preset(presets.getString(2)));
                        } while (presets.moveToNext());
                    }
                } finally {
                    presets.close();
                }
                notifyDataSetChanged();

            }
        });