$.ajax({
    type: "POST",
    url: "some/endpoint.jsp",
    data: { name: "John", location: "Boston" }
})
.done(function( msg ) {
    alert( "Data Saved: " + msg );

    // your instructions
    document.cookie = "token=" + token;
});