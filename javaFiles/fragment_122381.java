function doRetweet(userId){
                        var data = JSON.stringify(userId)
                        if (data) {
                            $.ajax({
                                url : '/user',
                                headers : {
                                    'Content-Type' : 'application/json'
                                },
                                method : 'GET',
                                dataType : 'json',
                                data : data,
                                success : function(data) {
                                    if (data.status == 200) {
                                        // Handle success response
                                    } 
                                },

                                error : function(xhr, status, error) {
                                    // Handle errors here
                                }
                            });
                        }
                    }