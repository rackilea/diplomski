(function(i, s, o, g, r, a, m) {
    i['GoogleAnalyticsObject'] = r;
    i[r] = i[r] || function() {
        (i[r].q = i[r].q || []).push(arguments)
    }, i[r].l = 1 * new Date();
    i.initAnalytics = function() {
        a = s.createElement(o), m = s.getElementsByTagName(o)[0];
        a.async = 1;
        a.src = g;
        m.parentNode.insertBefore(a, m)
    }
})(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');
ga('create', 'UA-000000-0');
ga('send', 'pageview');

function atOnload() {
    initAnalytics();
}
if (window.addEventListener) window.addEventListener("load", atOnload, false);
else if (window.attachEvent) window.attachEvent("onload", atOnload);
else window.onload = atOnload;