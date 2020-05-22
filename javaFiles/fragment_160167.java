@Configuration
class MongoCustomConverterConfig() {
    @Bean
    fun mongoCustomConversions(): MongoCustomConversions =
        MongoCustomConversions(listOf(
            YearToIntConverter(),
            IntToYearConverter()
        ))


    @WritingConverter
    class YearToIntConverter: Converter<Year, Int> {
        override fun convert(p0: Year): Int? = p0.value
    }

    @ReadingConverter
    class IntToYearConverter: Converter<Int, Year> {
        override fun convert(p0: Int): Year? = Year.of(p0)
    }

}