@RequestMapping(value = {"/welcome" }, method = RequestMethod.GET)
    public ModelAndView defaultPage(Principal pricipal,HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }
 $( document ).ajaxStart(function() {
  var token = $("meta[name='_csrf']").attr("content");
  var header = $("meta[name='_csrf_header']").attr("content");
  $(document).ajaxSend(function(e, xhr, options) {
    xhr.setRequestHeader(header, token);
  });
});

<meta name="_csrf" content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}"/>