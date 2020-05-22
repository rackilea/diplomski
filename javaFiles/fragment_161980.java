request = new CustomStringRequest(Request.Method.POST, "url", "checkIn",
     (response) -> {
         //Handle response
     },
     (error) -> {
         //Handle error
     });