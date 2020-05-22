actions: {
                        listAction: function () {
                            console.log("Loading from custom function...");
                            return $.Deferred(function ($dfd) {
                                $.ajax({
                                    url: "https://localhost:44328/api/employee-information/",
                                    type: 'GET',
                                    dataType: 'json',
                                    success: function (data) {
                                        console.log("Success");
                                        $dfd.resolve(data);
                                    },
                                    error: function () {
                                        console.log("Error");
                                        $dfd.reject();
                                    }
                                });
                            });
                        }
                    }