if (document.getElementById && !document.all) { // NOT for MSIE
    stickySizeOverloadOnload(stickySizeSetWindowSize);
    stickySizeOverloadOnresize(stickySizeSaveWindowSize);
}

function stickySizeSaveWindowSize(event)
{
    var expiry = new Date();
    var path = document.location.pathname;

    expiry.setDate(expiry.getDate()+500);
    stickySizeSetCookie('windowSize', window.outerWidth + ',' + window.outerHeight, expiry, path);
}

function stickySizeSetWindowSize()
{
    var saved=stickySizeGetCookie('windowSize');
    var parts=new Array();
    if (saved.length) {
    parts = saved.split(',');
    if ((parts[0]>100) && (parts[1]>100)) {
        window.outerWidth=parts[0];
        window.outerHeight=parts[1];
    } else {
        alert("invalid size - '" + saved + "'");
        stickySizeDeleteCookie('windowSize');
    }
}
}

function stickySizeOverloadOnload(func)
{
   var oldhandler=window.onload;
   if (typeof window.onload != "function") {
      window.onload=func;
   } else {
     window.onload=function(event) {
       oldhandler(event);
   func(event);
     }
   }
}
function stickySizeOverloadOnresize(func)
{
   var oldhandler=window.onresize;
   if (typeof window.onresize != "function") {
      window.onresize=func;
   } else {
      window.onresize=function(event) {
         oldhandler(event);
         func(event);
      }
   }
}

function stickySizeSetCookie(name, value, expires, path, domain, secure) {
  var curCookie = name + "=" + escape(value) +
  ((expires) ? "; expires=" + expires.toGMTString() : "") +
  ((path) ? "; path=" + path : "") +
  ((domain) ? "; domain=" + domain : "") +
  ((secure) ? "; secure" : "");
  document.cookie = curCookie;
}
function stickySizeGetCookie(name) {
   var dc = document.cookie;
   var prefix = name + "=";
   var begin = dc.indexOf("; " + prefix);
   if (begin == -1) {
      begin = dc.indexOf(prefix);
      if (begin != 0) return null;
   } else
      begin += 2;
   var end = document.cookie.indexOf(";", begin);
   if (end == -1)
   end = dc.length;
   return unescape(dc.substring(begin + prefix.length, end));
}
function stickySizeDeleteCookie(name, path, domain) {
   if (stickySizeGetCookie(name)) {
      document.cookie = name + "=" +
        ((path) ? "; path=" + path : "") +
        ((domain) ? "; domain=" + domain : "") +
        "; expires=Thu, 01-Jan-70 00:00:01 GMT";
   }
}