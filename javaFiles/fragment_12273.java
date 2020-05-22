<script language="text/javascript" defer>

function performAppletCode(count) {
    var applet = document.getElementById('MyApplet');

    if (!applet.myMethod && count > 0) {
       setTimeout( function() { performAppletCode( --count ); }, 2000 );
    }
    else if (applet.myMethod) {
       // use the applet for something
    }
    else {
       alert( 'applet failed to load' );
    }
}  

performAppletCode( 10 );

</script>