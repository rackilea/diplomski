String Text = driver.findElement(By.id("the_direct_path_to_this_span_<span class="ui-selectmenu-text">simplex</span>")).getText();
if(text.equals("Simplex"))
{
System.out.println("Is Simplex");
} else {

System.out.println("Is NOT Simplex");
}