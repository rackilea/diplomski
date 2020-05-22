public class AcmeInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {      

        AcmeController controller = (AcmeController) handler;

        AcmeModel acmeModel = controller.getAcmeModel();
        String key = "acmeModel";

        BeanPropertyBindingResult bpb = new BeanPropertyBindingResult(
                acmeModel, key);

        bpb.initConversion(controller.getBinder().getConversionService());

        modelAndView.addObject(key, acmeModel);
        modelAndView.addObject(BindingResult.MODEL_KEY_PREFIX + key, bpb);

    }

}