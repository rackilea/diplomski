private void updateLastChange()
{
    driver.executeScript("$('html').data('CHANGED_PAGE', false)");
}

public boolean pageChanged()
{
    Object script = driver.executeScript("return $('html').data('CHANGED_PAGE');");
    Boolean changed = (Boolean)script;
    if(changed == null)
    {
        updateLastChange();
        return true;
    }
    return false;
}