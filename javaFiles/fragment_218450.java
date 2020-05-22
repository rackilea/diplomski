//grid2 will initialize correctly
        $.ajax({
            type: "POST",
            url: '@Url.Action("GetJsonString", "Home")',
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (response) {
                var result = response;
                debugger;
                $("#grid2").igGrid({
                    autoGenerateColumns: false,
                    dataSource: result,
                    columns: [
                        { headerText: "ID", key: "id", dataType: "string" },
                        { headerText: "Name", key: "name", dataType: "string" },
                        { headerText: "Type", key: "type", dataType: "string" }
                    ],

                });
            },
            error: function (response) {

            }
        });