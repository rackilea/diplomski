@Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                         Bundle savedInstanceState) {
               View view = inflater.inflate(R.layout.fragment_main,  container, false);

     String[] forecastArray = {

                            "Today - Sunny - 54/89",
                            "Tomorrow - Cloudy - 45/60",
                            "Wednesday - Sunny - 66/77",
                            "Thursday - Sunny - 67/89",
                            "Friday - Sunny - 77/95",
                            "Saturday - Rain - 50/70",
                            "Sunday - Sunny - 67/88"
                    };

      List<String> weekForecast = new ArrayList<String>(
                            Arrays.asList(forecastArray));

                    ArrayAdapter<String> mForecastAdapter = new ArrayAdapter<String>(

                            getActivity(),

                            R.layout.list_item_forecast,

                            R.id.list_item_forecast_textview,

                            weekForecast

                    );



                    ListView listView = (ListView) view.findViewById(
                            R.id.listview_forecast);
                    listView.setAdapter(mForecastAdapter);

                    return view;
}