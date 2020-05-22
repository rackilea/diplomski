// two countries
   final String aut = "AUT";
   final String ger = "GER";

   // their states
   final List<String> autStates = Arrays.asList(new String[] { "V", "T", "S", "W" });
   final List<String> gerStates = Arrays.asList(new String[] { "NRW", "B", "BW" });

   // mapping, you should really get this data from a service or have a constant
   final Map<String, List<String>> countryToState = new HashMap<String, List<String>>(2);
   countryToState.put(aut, autStates);
   countryToState.put(ger, gerStates);

   // the container to send back via ajax
   final WebMarkupContainer cont = new WebMarkupContainer("cont");
   cont.setOutputMarkupId(true);
   add(cont);

   final Model<String> stateModel = new Model<String>();
   final DropDownChoice<String> countries = new DropDownChoice<String>("countries", new Model<String>(), new ArrayList<String>(countryToState.keySet()));
   final DropDownChoice<String> states = new DropDownChoice<String>("states", stateModel, new LoadableDetachableModel<List<String>>() {

        @Override
        protected List<String> load() {
            final String country = countries.getModelObject();
            final List<String> list = countryToState.get(country);

            return list != null ? list : new ArrayList<String>(0);
        }
   });

   countries.add(new AjaxFormComponentUpdatingBehavior("onchange") {

    @Override
    protected void onUpdate(AjaxRequestTarget target) {         
                    // just add the container to see the results
        target.addComponent(cont);
    }

   });

   cont.add(countries);
   cont.add(states);