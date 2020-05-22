public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    String[] forecastArray = { "Today - Sunny - 88/63",
            "Tomorrow - Foggy - 70/40", "Tuesday - Cloudy - 72/63",
            "Wednesday - Asteroids - 75/65",
            "Thursday - Heavy Rain - 65/56",
            "Friday - Help Trapped in weather Station  - 60/51",
            "Saturday - Sunny - 80/68" };
    return inflater.inflate(R.layout.fragment_main, container, false);
}