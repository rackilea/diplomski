timePhotoBefore = findViewById(R.id.timePhotoBefore);

    if(taskClass.getTime_photo_before() != null )
    {
        timePhotoBefore.setText(taskClass.getTime_photo_before());
        if (timePhotoBefore.getText().equals("NULL")
            timePhotoBefore.setText("No Time");
    }
    else
    {
        timePhotoBefore.setText("No time");
    }