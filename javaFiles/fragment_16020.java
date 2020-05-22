holder.mAppSelect.setOnCheckedChangeListener(null);
                    holder.mAppSelect.setChecked(mDataSet.get(position).isSelected());

    holder.mAppSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {


    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                                    mDataSet.get(position).setSelected(isChecked);

           sharedPreference.edit().putBoolean(mDataSet.get(position).getAppPackage(), isChecked).commit();
           });