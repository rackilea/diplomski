@RequestMapping(value = "/allPersons", method = RequestMethod.GET)
    public String getPersons(Model model) {
            LoadContext loadJohn = new LoadContext(John.class);
            loadJohn.setQueryString("select u from test6$John u");
            model.addAttribute("users", dataService.loadList(loadJohn));
            return "list";
    }