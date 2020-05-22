// set up references to both SELECTs
Select fromAccount = new Select(driver.findElement(By.id("fromAccount")));
Select toAccount = new Select(driver.findElement(By.id("toAccount")));

// other misc variables
String fromAcctNo = "";
String toAcctNo = "";

// find a personal account in the fromAccount OPTIONS
List<WebElement> options = fromAccount.getOptions();
for (WebElement option : options)
{
    // search for a personal account
    if (option.getText().contains("Personal"))
    {
        // store the account number
        fromAcctNo = option.getAttribute("value");
        break;
    }
}

if (fromAcctNo.equals(""))
{
    // log an error that a personal account was not found in fromAccount
}
else
{
    // find a personal account in the toAccount OPTIONS
    options = toAccount.getOptions();
    for (WebElement option : options)
    {
        // search for a personal account
        if (option.getText().contains("Personal"))
        {
            // find an account number that isn't the same as the fromAccount
            if (!option.getAttribute("value").equals(fromAcctNo))
            {
                toAcctNo = option.getAttribute("value");
                break;
            }
        }
    }
}

if (fromAcctNo.equals(""))
{
    // log an error that a personal account was not found in toAccount
}
System.out.println("fromAccountNo: " + fromAcctNo);
System.out.println("toAccountNo: " + toAcctNo);