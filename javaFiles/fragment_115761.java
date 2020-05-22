$(document).ready(function () {
    $(".navigation-icon").click(function () {
        $(".navigation").toggleClass('navigation-open');
        $('body').toggleClass('nav-open');
    });
});