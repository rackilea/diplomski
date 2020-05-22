jQuery(html).find("a[href]").each(function(index, value) {
  var $a = jQuery(value);
  var href = $a.attr("href");

  if(!/^http:/.test(href)) {
     $a.attr("href", "http://server-b.com" + href);
   }
});