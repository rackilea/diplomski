DropDownChoice choice = new DropDownChoice("hladaneSlovo", new HladaneSlova());
add(choice);
choice.add(new AjaxFormChoiceComponentUpdatingBehavior()
{
    @Override
    protected void onUpdate(AjaxRequestTarget target)
    {
        //The model is now updated so you can push to DB or pass as PageParameter to the next page

        // throw a RedirectException so that the url will be updated for your page
        throw new RedirectException(VyjimkyPage.class); 
    }
});