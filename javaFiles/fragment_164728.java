@ModelAttribute("pojoForm")
public PojoForm populatePojos() {
    // Don't forget to initialize the pojos list or else it won't work
    PojoForm pojoForm = new PojoForm();
    List<Pojo> pojos = new ArrayList<Pojo>();
    for(int i=0; i<2; i++) {
        pojos.add(new Pojo());
    }
    pojoForm.setPojos(pojos);
    return pojoForm;
}

@RequestMapping(method=RequestMethod.POST)
public String saveForm(@ModelAttribute("pojoForm") PojoForm pojoForm) {
    for(Pojo pojo : pojoForm.getPojos()) {
       service.save(pojo);
    }
    return "theview.jsp";
}