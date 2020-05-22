$(document).ready(function(){
    $(".linkDelete").click(function(){
        var userid = $(this).attr("userid");
        var url = "www.example.com?id=" + userid;
        alert(url);

        $.get( "/delete", function( data ) {
              alert( "Data Loaded: " + data );
        });
    });
});