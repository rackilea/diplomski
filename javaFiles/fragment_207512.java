if (context.getJobDetail().getKey().getName().equalsIgnoreCase(JobName.READRESPONSE.toString())) {
     // emailService.readMail();
     try {
         RestTemplate restTemplate = new RestTemplate();
         HttpEntity<MailMessage > request = new HttpEntity<>(mailMsg, new HttpHeaders());

         ResponseEntity<String> responseEntityStr = 
             restTemplate.postForEntity(
             String.format("http://localhost:7777/GoogleMail/%s", id), 
             request, String.class);

     } catch (IOException e) {
            e.printStackTrace();
     }