@RequestMapping("/signup-success")
        public String signupSuccess(){

            // create user 
            User user = new User();
            user.setFirstName("Dan");
            user.setLastName("Vega");
            user.setEmailAddress("dan@clecares.org");

            // send a notification
            try {
                notificationService.sendNotificaitoin(user);
            }catch( Exception e ){
                // catch error
                logger.info("Error Sending Email: " + e.getMessage());
            }

            return "Thank you for registering with us.";
        }