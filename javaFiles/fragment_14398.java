function populateChildDropdown(ddId) {
            var dd = $('#' + ddId);
            $.getJSON('json/mapping?dd=' + ddId, function(opts) {
                $('>option', dd).remove(); // Clear old options first.
                if (opts) {
                    $.each(opts, function(key, value) {
                        dd.append($('<option/>').val(key).text(value));
                    });
                } else {
                    dd.append($('<option/>').text("Please select the parent DD"));
                }
            });
        }