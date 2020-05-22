$('#imageUploadForm').submit(function(evt) {
                evt.preventDefault();

                var formData = new FormData(this);

                $.ajax({
                type: 'POST',
                url: $(this).attr('action'),
                data:formData,
                cache:false,
                contentType: false,
                processData: false,
                success: function(data) {
                    $('#imagedisplay').html("<img src=" + data.url + "" + data.name + ">");
                },
                error: function(data) {
                    $('#imagedisplay').html("<h2>this file type is not supported</h2>");
                }
                });
            });