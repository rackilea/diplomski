runOnUiThread(new Runnable() {
        @Override
        public void run() {
            if (value >= currentGoal) {
                Toast.makeText(getApplicationContext(), "Well done you reached your daily goal of " + currentGoal + " " + field,
                        Toast.LENGTH_LONG).show();
                currentGoal += stepGoalIncrement;
                tvHomeSteps.setText("today's " + field + " " + value + "/" + currentGoal);
            }
            else {
                tvHomeSteps.setText("today's " + field + " " + value + "/" + currentGoal);
            }
        }
    });

    new Thread(new Runnable() {
        @Override
        public void run() {
            while (value <= currentGoal) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        pbStepBar.setProgress(value);

                        if (value >= pbStepBar.getMax()) {
                            pbStepBar.setMax(currentGoal);
                            pbStepBar.setProgress(value);
                        }
                        else {
                            pbStepBar.setProgress(value);
                        }
                    }
                });
                try {
                    Thread.sleep(25);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //setNextGoal(pbStepBar, value);
            }
        }
    }).start();
}