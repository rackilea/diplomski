@Override
 public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)     {
    Activity looperActivity= getActivity();

    if(looperActivity instanceof SoftResetListener) {
      ((SoftResetListener)looperActivity).softReset();
    }

 }