//this can be used even if the element is not visible
//if you want to hover over the element, replace click() with hover() 
((JavascriptExecutor)driver).executeScript("$('element_selector').click();");

OR

you can use Actions class rather than using the Keyboard or Mouse directly. 
It implements the builder pattern: Builds a CompositeAction containing all actions specified by method calls