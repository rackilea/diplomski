if (isCharging) {

            //Gets the 'last synced' string and sets to datetime of the last sync
            Resources resources = context.getResources();
            String chargingString = String.format(resources.getString(R.string.charging), level);

            //Dynamically sets the value of the battery level
            batteryLowTextView.setVisibility(TextView.INVISIBLE);
            batteryLowImageView.setVisibility(ImageView.INVISIBLE);
            batteryTextView.setText(chargingString + "%");
            batteryTextView.setVisibility(TextView.VISIBLE);
            batteryImageView.setVisibility(ImageView.VISIBLE);

        } else if (level <= LOW_BATTERY_LEVEL) {

            Resources resources = context.getResources();
            String lowBatteryString = String.format(resources.getString(R.string.low_battery));

            batteryTextView.setVisibility(TextView.INVISIBLE);
            batteryImageView.setVisibility(ImageView.INVISIBLE);
            batteryLowTextView.setText(lowBatteryString);
            batteryLowTextView.setVisibility(TextView.VISIBLE);
            batteryLowImageView.setVisibility(ImageView.VISIBLE);

        } else {

            //show nothing
            batteryTextView.setVisibility(TextView.GONE);
            batteryImageView.setVisibility(ImageView.GONE);
            batteryLowTextView.setVisibility(TextView.GONE);
            batteryLowImageView.setVisibility(ImageView.GONE);
        }