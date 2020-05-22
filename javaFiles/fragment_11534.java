private fun example(dtos: List<Dto>): Map<String, Map<String, String>> {

    if (dtos.isEmpty()) {
        return emptyMap()
    }

    val outerMapByField1 = sortedMapOf<String, MutableMap<String, String>>()

    dtos.forEach { dto ->

        val field1 = dto.field1

        val innerMapByField2 = outerMapByField1.getOrPut(field1) { TreeMap() }
        innerMapByField2.put(dto.field2, dto.field3)

    }

    return outerMapByField1

}