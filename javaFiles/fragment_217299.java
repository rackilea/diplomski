@ExceptionHandler(MyException.class)
public ModelAndView handler(MyException me){
                ModelAndView model = new ModelAndView("index");
                model.addObject("error", me.getMessage());

                return model;
        }
}