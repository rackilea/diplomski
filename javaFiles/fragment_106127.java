@Test
    @Transactional
    fun `'addLog' should return the created entity`() {
        val result = service.addLog(logCreateDTO = LogCreateDTO())
        assertThat(result).isNotNull()
        assertThat(result.id).isNotNull()
    }