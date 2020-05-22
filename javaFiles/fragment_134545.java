import com.fasterxml.jackson.databind.MappingIterator
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.csv.CsvSchema
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.core.io.ClassPathResource


inline fun <reified T> readCsv(filename: String): List<T> {
    // configure mapper, schema and reader
    val mapper = CsvMapper().apply { registerModule(KotlinModule()) }
    val bootstrapSchema = CsvSchema.emptySchema().withHeader()
    val objectReader = mapper.readerFor(T::class.java).with(bootstrapSchema)

    //Read File and produce list from CSV
    ClassPathResource(filename).inputStream.use {
        val mappingIterator: MappingIterator<T> = objectReader.readValues(it)

        val items = mutableListOf<T>()

        mappingIterator.forEach { items.add(it) }

        return items.toList()
    }
}