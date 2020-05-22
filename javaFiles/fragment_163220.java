function create_site()
{
var sc_form = document.forms.namedItem('sc_form');
var name = sc_form.elements.namedItem('name').value;

var url = Alfresco.constants.URL_CONTEXT + "service/modules/create-site";

Alfresco.util.Ajax.request({

    method : Alfresco.util.Ajax.POST,

    url : url,

    dataObj: {
        sitePreset: "site-dashboard",
        visibility: "PUBLIC",
        title: name,
        shortName: name,
        description: name
    },

    requestContentType: Alfresco.util.Ajax.JSON,

    successCallback: 
    {
        fn: function(res){
           alert("success");
           alert(res.responseText);                                                                                            
        },

        scope: this

    },

    failureCallback: 
    {
       fn: function(response)
       {
          Alfresco.util.PopupManager.displayPrompt(
          {
             title: Alfresco.util.message("message.failure", this.name),
             text: "search failed"
          });                                          
       },
       scope: this
    }
});
}