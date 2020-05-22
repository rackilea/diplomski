cbBM = view.findViewById(R.id.bm);
    cbBM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked)
        {
            checkNoSelection()
        }
    });