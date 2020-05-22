@ControllerAdvice
class ApiErrorHandler {

  @ExceptionHandler(value = [MyExternalApiException::class])
  fun handleExternalApiException(e: MyExternalApiException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(ErrorResponse(e.message
                        ?: "External api error"))
    }

 data class ErrorResponse(val message: String)