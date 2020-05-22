try {
        Date mToday = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");
        String curTime = sdf.format(mToday);
        Date start = sdf.parse("4:15 PM");
        Date end = sdf.parse("2:00 AM");
        Date userDate = sdf.parse(curTime);

        if(end.before(start))
        {
            Calendar mCal = Calendar.getInstance();
            mCal.setTime(end);
            mCal.add(Calendar.DAY_OF_YEAR, 1);
            end.setTime(mCal.getTimeInMillis());
        }

        Log.d("curTime", userDate.toString());
        Log.d("start", start.toString());
        Log.d("end", end.toString());


        if (userDate.after(start) && userDate.before(end)) {
            Log.d("result", "falls between start and end , go to screen 1 ");
        }
        else{
            Log.d("result", "does not fall between start and end , go to screen 2 ");
        }
    } catch (ParseException e) {
        // Invalid date was entered
    }