// from domain.com to your server, example.com, make a request using a script tag
var urlWithParams = "http://example.com/getHTMLForm.do?id2=" + id2 + "&name2" + name2;
var script = document.createElement("script");
script.setAttribute("type","text/javascript");
script.setAttribute("src", urlWithParams);

// create a script tag, which invokes your servlet 
document.getElementsByTagName("head")[0].appendChild(script);