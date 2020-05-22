class ApiResponseValidatorJava(vararg validators: ModelValidator<out Any?>) : Converter.Factory() {

    private val validators = mutableMapOf<Type, ModelValidator<Any?>>().apply {
        validators.forEach {
            @Suppress("UNCHECKED_CAST")
            this[it.getModelType()] = it as ModelValidator<Any?>
        }
    }

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *> {
        val mainConverter = retrofit.nextResponseBodyConverter<Any?>(this, type, annotations)
        return Converter<ResponseBody, Any?> { value ->
            mainConverter.convert(value).also { apiResponseModel ->
                validators[type]?.validate(apiResponseModel)
            }
        }
    }
}