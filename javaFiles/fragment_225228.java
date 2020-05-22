holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    checkedBoxesCount++;
                else
                    checkedBoxesCount--;

                if(checkedBoxesCount > 0 ){
                    EquipmentDataActivity.btnDownload.setVisibility(View.VISIBLE);
                }else{
                    EquipmentDataActivity.btnDownload.setVisibility(View.GONE);
                }
            }
        });