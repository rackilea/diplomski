import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper


@JsonIgnoreProperties(ignoreUnknown = true)
class Item99 {
    var p1: String? = null
    var types: Array<String>? = null
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Item994 {
    var p1: String? = null
    var types: Array<String>? = null
}

class Wrapper {
    @JsonProperty("Item99")
    var item99: Array<Item99>? = null

    @JsonProperty("Item994")
    var item994: Array<Item994>? = null
}

object Main {

    var jsonString = "{\n" +
            "    \"Item994\": [\n" +
            "        {\n" +
            "            \"attributeToRemove\": {\n" +
            "                \"someItem\": null\n" +
            "            },\n" +
            "            \"types\": [\n" +
            "                \"type194\",\n" +
            "                \"type294\"\n" +
            "            ],\n" +
            "            \"p1\": \"SOS\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"Item99\": [\n" +
            "        {\n" +
            "            \"attributeToRemove\": {\n" +
            "                \"someItem\": null\n" +
            "            },\n" +
            "            \"types\": [\n" +
            "                \"type19\",\n" +
            "                \"type29\"\n" +
            "            ],\n" +
            "            \"p1\": \"SOS\"\n" +
            "        }\n" +
            "    ]\n" +
            "}"

    @JvmStatic
    fun main(args: Array<String>) {
        val mapper = ObjectMapper()
        mapper.visibilityChecker = mapper.serializationConfig.defaultVisibilityChecker.withCreatorVisibility(JsonAutoDetect.Visibility.ANY)
        val answer = mapper.readValue(jsonString, Wrapper::class.java)
        print(mapper.writeValueAsString(answer))
    }
}