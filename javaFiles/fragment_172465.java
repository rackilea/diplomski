if(stringContainsItemFromList(driver.getPageSource(), new String[] {"google", "otherword"))
{
    driver.close();
    driver.switchTo().window(winHandleBefore);
}

 public static boolean stringContainsItemFromList(String inputStr, String[] items)
    {
        for(int i =0; i < items.length; i++)
        {
            if(inputStr.contains(items[i]))
            {
                return true;
            }
        }
        return false;
    }