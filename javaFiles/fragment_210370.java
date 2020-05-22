// changes all input elements on the page to radio buttons
js.executeScript(
        "var inputs = document.getElementsByTagName('input');" +
        "for(var i = 0; i < inputs.length; i++) { " +
        "    inputs[i].type = 'radio';" +
        "}" );