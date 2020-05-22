sectionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    public void onItemSelected(AdapterView<?> parent, android.view.View v, int pos, long id) {
        if (userSelected) {
            resetAction();
            setTimeText(sectionTimes[pos], sectionTimes[pos]);
            currentSection = pos + 1;
            setSectionText(currentSection);
            currentStartTime = sectionTimes[pos];
            currentTime = currentStartTime;
            setSeekBarProgress(currentTime, currentStartTime);
        } else {
            userSelected = true;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }
});