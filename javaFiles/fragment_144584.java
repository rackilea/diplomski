class MyRestTemplateResponseErrorHandler : ResponseErrorHandler {
 override fun hasError(response: ClientHttpResponse): Boolean {
   return response.statusCode.is4xxClientError || response.statusCode.is5xxServerError //or sth else depending on your case
 }
 override fun handleError(response: ClientHttpResponse) {
   val msg = response.body.bufferedReader().use(BufferedReader::readText)
   throw MyExternalApiException(msg)
 }
}