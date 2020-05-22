actions: {
                    listAction: function (postData, jtParams) {
                        return $.Deferred(function ($dfd) {
                            $.ajax({
                                url: 'https://localhost:44328/api/employee-information?' + jtParams.jtStartIndex + '&jtPageSize=' + jtParams.jtPageSize + '&jtSorting=' + jtParams.jtSorting,
                                type: 'GET',
                                dataType: 'json',
                                success: function (data) {
                                    $dfd.resolve({ Records: data.records, Result: data.result, TotalRecordCount: data.totalRecordCount });
                                },
                                error: function () {
                                    $dfd.reject();
                                }
                            });
                        });
                    }
                }