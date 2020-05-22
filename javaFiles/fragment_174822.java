<@markup id="js">
    <@script type="text/javascript" src="${url.context}/res/jquery/jquery-1.6.2-min.js" group="form" />
</@>

<script type="text/javascript">//<![CDATA[
    // grab the field1 dropdown element
    var field1El = $("#template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_sc_field1");

    // declare a function that knows how to show/hide the div
    var toggleField2 = function(field1) {
        if (field1 === "Show Field2") {
            $("#field2").show();
        } else {
            $("#template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_sc_field2").val('');
            $("#field2").hide();            
        }
    }

    // bind the field1 dropdown element's change event to a function that calls our toggle function 
    field1El.bind("change", function(e) {
        var selected = $("option:selected", this);
        var field2 = this.value;
        toggleField2(field2);
    });

    // invoke the toggle function based on the current value of the dropdown before it is changed
    // by the user, ie, when the form is first opened
    toggleField2(field1El.find("option:selected").text());
//]]></script>