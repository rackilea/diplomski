$("form").submit(
                function() {
                    var val = $("input[type=submit][clicked=true]").attr(
                            'id');
                    if (val == 'pdf_button') {
                        $("#myForm").attr('target', '_blank');
                        $("#myForm").attr(
                                'action',
                                /Path/To/Print/Servlet
                    }
                });
        $("form input[type=submit]").click(
                function() {
                    $("input[type=submit]", $(this).parents("form"))
                            .removeAttr("clicked");
                    $(this).attr("clicked", "true");
                });