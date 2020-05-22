<script lang="text/javascript">
    var clients = <%= new Gson().toJson(clients) %>;

    // Fill the first dropdown.
    $("#myDropdown").empty();
    $.each(clients, function() {
        $("<option/>").attr("value", this.id).text(this.name).appendTo("#myDropdown");
    });

    $("#myDropdown").on("change", function(event) {
        var selectedClientId = $("#myDropdown").val();
        var client = $.grep(clients, function(client) {
            return client.id = selectedClientId;
        });
        $("#myOtherDropdown").val(client.someOtherValue);
    });
</script>

...

<select id="myDropdown" name="..."></select>

...

<select id="myOtherDropdown" name="..."></select>