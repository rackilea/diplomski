<aui:script use="aui-base,aui-io-request">
    A.one('#<portlet:namespace/>save').on('click', function(event) {
        var A = AUI();
        var url = '<%=editURL.toString()%>';

        A.io.request(
            url,
            {
                method: 'POST',
                form: {id: '<portlet:namespace/>fm'},
                on: {
                    success: function() {
                        Liferay.Util.getOpener().refreshPortlet();
                        Liferay.Util.getOpener().closePopup('popupId');
                    }
                }
            }
        );

    });
</aui:script>