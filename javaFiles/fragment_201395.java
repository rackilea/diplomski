JavascriptExecutor js = (JavascriptExecutor) driver;
List<String> actualMessages = new ArrayList<>();
for (int i = 0; i < 30000; i++) {
    actualMessages.addAll(
            (ArrayList<String>) js.executeScript("return [...document.querySelectorAll('p.statusText')].map(e=>{return e.textContent})")
    );

    Thread.sleep(10);
}
// debug here to check message collected
System.out.println(actualMessages);