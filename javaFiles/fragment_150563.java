public PageObjectClassExample ShowFilters()
    {
        showFiltersButton.Click();
        return this;
    }
    public PageObjectClassExample ClearAllFilters()
    {
        finalDatePicker.Clear();
        initialDatePicker.Clear();
        searchButton.Click();
        return this;
    }
    public PageObjectClassExample HideShowIssuerColunm()
    {
        ShowHideColumnBtn.Click();
        IssuerColumnCheck.Click();
        KeyColumnCheck.Click();
        ShowHideColumnBtn.Click();
        return this;
    }