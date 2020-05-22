<aui:script use="aui-form-validator">
    new A.FormValidator({
        boundingBox: $("<portlet:namespace />myForm"),
        rules: {
            <portlet:namespace />promotionAssignment: {
                required: true
            }
        },
        fieldStrings: {
            <portlet:namespace />promotionAssignment: {
                required: 'Please select at least one client'
            }
        }
    });
</aui:script>