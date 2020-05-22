// ...

    for (int i = 0; i < mObjects.size(); ++i) {
        object = mObjects.get(i);
        object.image.setOnClickListener(new ObjectClickListener(object));
        object.image.setOnLongClickListener(new ObjectLongClickListener(object));
    }

    private class ObjectClickListener implements View.OnClickListener {

        ExampleObject mObject;

        ObjectClickListener(ExampleObject object) {
            mObject = object;
        }

        @Override
        public void onClick(View v) {
            countDownEditText = findViewById(R.id.countdownEditText);
            if (countDownEditText.getText().toString().equals("")) {
                showToastText(R.string.count_down_time);
                return;
            }
            if (mObject.checkReadyForAction()) {
                countDownTime = Integer.parseInt(countDownEditText.getText().toString());
                mObject.startCountDown(countDownTime);
            } else {
                showToastText(R.string.action_not_ready);
            }
        }
    }

    private class ObjectLongClickListener implements View.OnLongClickListener {

        ExampleObject mObject;

        ObjectLongClickListener(ExampleObject object) {
            mObject = object;
        }

        @Override
        public boolean onLongClick(View v) {
            mObject.reset();
            return true;
        }
    }