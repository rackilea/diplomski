// Prevent memory leaks in IE
// And  prevent errors on refresh with events  like mouseover in other  browsers
// Window isn't included so as not to unbind existing unload events
jQuery(window).bind("unload",
function() {
        jQuery("*").add(document).unbind();
});