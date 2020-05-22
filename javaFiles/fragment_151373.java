public HandlerExceptionResolver handlerExceptionResolver()
{
    return new HandlerExceptionResolver()
    {
        @Override
        public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
        {
            return null;
        }
    };
}