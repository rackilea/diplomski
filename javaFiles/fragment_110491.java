<script lang="text/javascript">
    var clientIdToOtherValueMap = {
        <%
        for (Client client : clients) {
            %>
            '<%= client.id %>': '<%= client.otherDropdownId %>',
            <%
        }
        %>
        '': ''
    };

    // Fill the first dropdown.
    $("#myDropdown").on("change", function(event) {
        $("myOtherDropdown").val(clientIdToOtherValueMap[$("#myDropdown").val()]);
    });
</script>

...

<select id="myDropdown" name="..."></select>

...

<select id="myOtherDropdown" name="..."></select>