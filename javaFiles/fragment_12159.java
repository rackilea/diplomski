int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
mViewInfo.setText("Battery Scale : " + scale);

int level = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
mViewInfo.setText(mViewInfo.getText() + "\nBattery Level : " + level);

float percentage = level/ (float) scale;
mProgressStatus = (int)((percentage)*100);