function insertFormOnPage( data ) {

    alert( data.html ); // prints the HTML for debugging
    alert( data.elem ); // prints the selector you want to insert into

    // inject the HTML into the #content DIV
    $( data.elem ).html( data.html );
}