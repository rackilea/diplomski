$.ajax({
                            type: 'GET',
                            url: '<?php echo base_url(); ?>"/RegisterStudent"', // your syntax
                            data: {
                                'firstName ': firstName ,
                                'lastName'  :lastname,
                                'phone': phone,
                                'email' : email,
                                'studentCode' : studentCode,

                            },
                           success : function(data) {
                    var ht = data.msg;
                    $("#resp").html(ht);
                },
                error : function(data) {
                    alert("Some error occured.");
                }
                        });