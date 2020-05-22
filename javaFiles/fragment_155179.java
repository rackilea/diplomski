@Test
public fun test_correctParkIdMappingGeneration() {

    Mockito.`when`<ParkIdMapping>(parkIdMappingRepository.save(any())).thenAnswer(
        { invocation -> // compiler error
            val mapping = invocation.getArgument<ParkIdMapping>(0)
            mapping.id = 100L
            mapping
        }
    )
    val mapping = parkIdMappingRepository.save(ParkIdMapping("123"))

    assertEquals(100L, mapping.id)
}