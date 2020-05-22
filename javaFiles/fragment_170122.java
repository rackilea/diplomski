class ErrorInfoImpl(
  private val code: String,
  private val message: String
) : ErrorInfo {
    override fun getCode(): String = code
    override fun getMessage(): String = message
}