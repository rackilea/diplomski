public class CommonDataInjectingInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private CommonDataHolder holder;

    public void setCommonDataHolder(CommonDataHolder holder) {
        this.holder = holder;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (holder != null && modelAndView != null) {
            modelAndView.addObject("menu", holder.getMenu());
            modelAndView.addObject("footer", holder.getFooter());
        }
    }
}