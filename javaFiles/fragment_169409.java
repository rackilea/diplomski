public ModelAndView SController(ModelMap model)
{
    P p = new P();
    List<P> myList = (List<P>) this.myservice.getList("abcd");

    for (P lst : myList)
        p.setName(lst.getName());

}