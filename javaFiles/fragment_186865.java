function base642bin(s) {
    var b = "", e = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    for (var i = 0; i < 10; i++) b += ("00000" + e.indexOf(s.charAt(i)).toString(2)).substr(-6);
    return b;
}
document.write(base642bin("EjRWeJq83v"));