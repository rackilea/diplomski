public class TestPage3 extends WebPage {

    FeedbackPanel feedbackPanel;
    Set<String> selectedStates = new HashSet<String>();
    Set<String> selectedCountries = new HashSet<String>();
    Set<String> allStatesSelected = new HashSet<String>();

    public TestPage3(final PageParameters parameters) {

        feedbackPanel = new FeedbackPanel("feedback");
        feedbackPanel.setOutputMarkupId(true);
        add(feedbackPanel);

        Form<Void> form = new Form<Void>("form");
        add(form);

        addFormComponents(form);
    }

    private void addFormComponents(Form<Void> form) {
        ListMultipleChoice<String> statesSelection = addStatesMultipleChoicesBox(form);
        ListMultipleChoice<String> countriesSelection = addCountryMultipleChoiceBox(form, statesSelection);
    }

    private ListMultipleChoice<String>  addCountryMultipleChoiceBox(Form<Void> form, final ListMultipleChoice<String> statesSelection) {

        final Map<String, String> countryMap = new HashMap<String, String>();

        countryMap.put("US", "United States of America");
        countryMap.put("IN", "India");
        countryMap.put("JA", "Japan");
        countryMap.put("AA", "AA");
        countryMap.put("BB", "BB");

        final ListMultipleChoice<String> choices = new ListMultipleChoice<String>("countries", new PropertyModel<Collection<String>>(this, "selectedCountries"), new ArrayList<String>(countryMap.keySet()));
        choices.add(new AjaxFormComponentUpdatingBehavior("onchange") {
            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                if (allStatesSelected != null && allStatesSelected.size() > 0){
                    statesSelection.setChoices(new ArrayList<String>(allStatesSelected));
                    target.add(statesSelection);
                }
            }
        });

        choices.setOutputMarkupId(true);
        form.add(choices);
        return choices;
    }

    private ListMultipleChoice<String> addStatesMultipleChoicesBox(Form<Void> form) {

        final Map<String, String> statesMap = new HashMap<String, String>();

        statesMap.put("AK", "Arkansas");
        statesMap.put("FL", "Florida");
        statesMap.put("IL", "Illinois");
        statesMap.put("SA", "State A");
        statesMap.put("SB", "State B");
        statesMap.put("SC", "State C");
        statesMap.put("SD", "State D");

        final ListMultipleChoice<String> choices = new ListMultipleChoice<String>("states", new PropertyModel<Collection<String>>(this, "selectedStates"), new ArrayList<String>(statesMap.keySet())){

            @Override
            protected void onModelChanged() {
                for (String selectedState : selectedStates){
                    allStatesSelected.add(selectedState);
                }
            }
        };

        choices.setOutputMarkupId(true);
        form.add(choices);

        return choices;
    }

    public Set<String> getSelectedStates() {
        return selectedCountries;
    }

    public void setSelectedStates(Set<String> selectedStates) {
        this.selectedCountries = selectedStates;
    }

    public Set<String> getSelectedCountries() {
        return selectedCountries;
    }

    public void setSelectedCountries(Set<String> selectedCountries) {
        this.selectedCountries = selectedCountries;
    }
}