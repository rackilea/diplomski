private void exportChartCsv() {
        mDatabaseHelper = new DatabaseHelper(this);
        try {
            mWriter = new CSVWriter(new FileWriter(Environment.getExternalStorageDirectory().getAbsolutePath() + "/charts.csv"));
            mChartList = mDatabaseHelper.getChartsList();
            String[] mExportChartHeaders = {
                    "Chart ID", 
                    "User ID", 
                    "Patient ID", 
                    "First Name", 
                    "Last Name", 
                    "Date of Birth", 
                    "Telephone Number", 
                    "Photo Path", 
                    "TimeStamp", 
                    "Questions Completed"
            };

            mWriter.writeNext(mExportChartHeaders);

            for (ChartTable chartTable : mChartList) {
                mId = String.valueOf(chartTable.getId());
                mUserId = chartTable.getUserId();
                mPatientId = chartTable.getPatientId();
                mFirstName = chartTable.getFirstName();
                mLastName = chartTable.getLastName();
                mDateOfBirth = chartTable.getDob();
                mTelephoneNumber = chartTable.getPhone();
                mPhotoPath = chartTable.getPhoto();
                mTimeStamp = chartTable.getTimeStamp();
                mQuestionsCompleted = String.valueOf(chartTable.getQuestionsCompleted());

                String[] mExportChart = {mId, mUserId, mPatientId, mFirstName, mLastName, mDateOfBirth, mTelephoneNumber, mPhotoPath, mTimeStamp, mQuestionsCompleted};
                mWriter.writeNext(mExportChart);
            }
            mWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mDatabaseHelper.close();
    }