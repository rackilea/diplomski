class PaperDay (dateWithTime: Date, 
                private val weather: Weather = Weather.SUNNY): Day {

    private val date: Date = truncateTimeFromDate(dateWithTime)

    ...
}