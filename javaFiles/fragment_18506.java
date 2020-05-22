public String doSomething(Model model){
    return "test";
}
public ModelAndView i_am_similar_to_doSomething(){
    return new ModelAndView("test");
}

//You can guess that you can do the same thing with redirect.