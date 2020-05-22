public class ErrorController extends AbstractController  {


    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
            HttpServletResponse arg1) throws Exception {
        // TODO Auto-generated method stub

        ModelAndView mv = new ModelAndView();
        mv.setViewName("errorPage");        
        return mv;
    }

}