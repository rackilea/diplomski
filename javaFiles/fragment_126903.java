@Bean
public ErrorAttributes errorAttributes() {
    return new DefaultErrorAttributes() {
        @Override
        public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {

            Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);

            Throwable error = getError(requestAttributes);

            if (error instanceof MyException) {
                MyException myException = (MyException) error;
                int httpStatus = myException.getStatus();

                errorAttributes.put("errorCode", myException.getErrorCode());
                errorAttributes.put("message", myException.getMessage());
                errorAttributes.put("status", httpStatus);

                HttpStatus correspondentStatus = HttpStatus.valueOf(httpStatus);
                errorAttributes.put("error", correspondentStatus.getReasonPhrase());
                requestAttributes.setAttribute("javax.servlet.error.status_code", httpStatus, 0);
            }

            return errorAttributes;
        }
    };
}