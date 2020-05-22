//On controller

public static void yourRequest() {
   //...
   Object display = getDisplay(); //get your value
   render(display);
}

//On template
<div style="display: ${display}">...</div>