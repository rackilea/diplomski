function send_message(message) {
            var data = {"data":message};
            $.ajax({
                type: 'POST',
                url: "ret.php",
                data: data,
                success: function(returned) {
                    console.log(returned);
                },
                error: function(json) {
                     console.log(json);
                },
                abort: function(json) {
                }
            });
        }