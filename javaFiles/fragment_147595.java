String dep_min_time = (String.valueOf(minHour)+ ":" + String.valueOf(minMinute));
            String dep_max_time = (String.valueOf(maxHour)+ ":" + String.valueOf(maxMinute));

            dep_min_time1_txt.setText(DateUtil.TimeFormat(dep_min_time));
            dep_max_time1_txt.setText(DateUtil.TimeFormat(dep_max_time));



        }
    });