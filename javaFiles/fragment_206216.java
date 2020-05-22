org.openqa.selenium.Dimension  dm = driver.manage().window().getSize();

int relativemaxheight = 1280; // put your screen resolution height
int relativemaxwidth = 800;   // put your screen resolution width

if(dm.height < relativemaxheight && dm.width < relativemaxwidth){
    System.out.println("minimized");
}