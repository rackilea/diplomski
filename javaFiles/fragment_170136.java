AUI().use('aui-base','aui-node','aui-dialog','aui-io-request', 'aui-io','liferay-portlet-url','aui-dialog-iframe', function(A) {
var url =Liferay.PortletURL.createRenderURL();    
    url.setPortletId('signinaction_WAR_WatsonSiginInportlet');  
    url.setWindowState('pop_up'); 
    var myAjaxRequest=A.io.request(url.toString(), {
          dataType: 'html',
          autoLoad: false,
          on: {
           success: function() {
            // A.one('#testestDiv').set('innerHTML',"meera");
             document.getElementById("login-portlet-content").innerHTML=this.get('responseData');
             //A.one('#loginBoxDiv').set('innerHTML',this.get('responseData'));
           }
          }
        });

myAjaxRequest.start();
});