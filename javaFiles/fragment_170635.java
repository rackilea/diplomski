private void updateWhenReady(){

    System.out.println(validCurrent+ " " +  validDaily + " " + validHourly );

    weatherList = dbHelper.getWeatherConditionsHashMap();
    hourlyList = new ArrayList<WeatherCondition>(weatherList.keySet());
    adapter = new WeatherSearchListAdapter(getActivity().getApplicationContext(), weatherList, hourlyList);

    System.out.println(validCurrent + " " + validDaily + " " + validHourly);

    if(validCurrent && validDaily && validHourly)
    {   
        System.out.println("in");


        for (WeatherCondition wc: dailyResponseList)
        {
            ArrayList<WeatherCondition> tempList = new ArrayList<>();
            for(WeatherCondition w: hourlyResponseList)
            {
                if(w.getDate().equalsIgnoreCase(wc.getDate()))
                {
                    tempList.add(w);
                }
            }

            weatherList.put(wc,tempList);

        }

        for (WeatherCondition weatherCondition: weatherList.keySet())
        {
            System.out.println(" +   " + weatherCondition.getDate());
        }

        //Do you need to reset these? What if only two of the three were true?
            validCurrent = false;
            validDaily = false;
            validHourly = false;
        }
    }
    expList.setAdapter(adapter);
    /* If you are setting adapter every time *updateWhenReady* is invoked, no need to notifyDataSetChanged, because its a new adapter and layout will be drawn fresh */
    //adapter.notifyDataSetChanged();

}