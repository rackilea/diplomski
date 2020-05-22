private fun fileToKotlin(text: String, settings: ConverterSettings, project: Project): String {
    val file = createJavaFile(text)
    val converter = JavaToKotlinConverter(project, settings,
                                          IdeaReferenceSearcher, IdeaResolverForConverter)
    return converter.filesToKotlin(listOf(file), J2kPostProcessor(formatCode = true)).results.single()
}