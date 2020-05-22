Wtf.Ajax.requestEx({
 url: "MyJspPage.jsp",
 params: {
   requestType: 1,
   htmlcode: escape("Chào")
 },
 method: 'POST'
},
 this,
 function (response, request) {
});