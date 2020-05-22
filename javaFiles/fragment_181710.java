@Test 
public void checkClipboardForCopy() {

String cFirstContent = null;
String cSecondContent = null;
IIDG idGenTab = goToIdG();
idGT.getRadioButton().click();
idGT.getButton().click();
browser.wait.until(loadingMarkerGone());
browser.findElement(By.id("IDClip")).click();
try {
   Thread.sleep(1000);
    } catch (InterruptedException interrupt) {
    }   
try {
    cFirstContent = getClipboardContents();
} catch (Exception e) {
    e.printStackTrace();
}
String firstValue = idGT.getNewId().getAttribute("value") ;
verifyThat("Value of clipboard", cFirstContent, not(isEmptyOrNullString()));
verifyThat("Value of id", idGT.getNewId().getAttribute("value"), not(isEmptyOrNullString()));
verifyThat("Compare value of first clipboard content to attribute value", cFirstContent, equalTo(idGT.getNewId().getAttribute("value")));
idGT.getButton().click();
browser.wait.until(loadingMarkerGone());
browser.findElement(By.id("IDClip")).click();
try {
    Thread.sleep(1000);
    } catch (InterruptedException interrupt) {
    }
try {
    cSecondContent = getClipboardContents();
} catch (Exception e) {
    e.printStackTrace();
}
String secondValue = idGT.getNewId().getAttribute("value") ;
verifyThat("Value of clipboard", cSecondContent, not(isEmptyOrNullString()));
verifyThat("Value of id", idGT.getNewId().getAttribute("value"), not(isEmptyOrNullString()));
verifyThat("Compare value of second clipboard content to attribute value", cSecondContent, equalTo(idGT.getNewId().getAttribute("value")));
verifyThat("Compare value of first and second clipboard contents", cSecondContent, greaterThan(cFirstContent));  
}