$(document).ready(function() {
    console.log("document ready");
    setTimeout(function() {
        console.log("calling openSession...");
        document.myApplet.openSession();
    }, 2000);
});