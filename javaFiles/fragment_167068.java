error: function(jqXHR, status, thrownError) {
                    alert("Something went wrong!" + "\n" +
                            "Status: " + status + "\n"); // <---- keeps erroring
                    alert(thrownError);
                    console.log(thrownError);
                }