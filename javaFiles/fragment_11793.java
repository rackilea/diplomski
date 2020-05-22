public class MyRequestFooResolver implements HandlerMethodArgumentResolver {

        @Override
        public boolean supportsParameter(MethodParameter parameter) {

            return parameter.getParameterType().equals(MyRequestFoo.class);
        }

        @Override
        public Object resolveArgument(MethodParameter parameter, 
                                      ModelAndViewContainer mavContainer,
                                      NativeWebRequest webRequest, 
                                      WebDataBinderFactory binderFactory)
        throws Exception {

            return new MyRequestFoo();
        }
    }