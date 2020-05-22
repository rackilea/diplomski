@RestControllerAdvice
public class SampleAdvice implements ResponseBodyAdvice<Sample>{

    @Override
    public Sample beforeBodyWrite(Sample sample, MethodParameter arg1, MediaType arg2,
            Class<? extends HttpMessageConverter<?>> arg3, ServerHttpRequest arg4, ServerHttpResponse arg5) {
        // Get a handle to your response object and make changes here
        sample.setProperty("Overridden Property");
        return sample;
    }

    @Override
    public boolean supports(MethodParameter arg0, Class<? extends HttpMessageConverter<?>> arg1) {
        return true;
    }
}