WebElement planet;
int size = driver.findElements(By.className("smallplanet")).size();
for(int i=0; i < size; i++)
{           
    if(!firstPlanet)
    {
        planet = driver.findElements(By.className("smallplanet")).get(i);
        WebElement tag = planet.findElement(By.tagName("a"));
        tag.click();
        planet = driver.findElements(By.className("smallplanet")).get(i);

    } else
    {
        firstPlanet = false;
        planet = driver.findElements(By.className("smallplanet")).get(i);
    }
    //rest of the code...
}