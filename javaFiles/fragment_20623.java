List<User> users = userService.findAll();
            boolean isUserNameExist = false;
            boolean isPasswordExist = false;
            boolean isUserTypeExist = false;
            for (User u : users) {
                if (u.getUserName().equals(user.getUserName())) {
                    isUserNameExist = true;
                    break;
                } 
            }

            for (User u : users) {
               if (u.getPassword().equals(user.getPassword())) {
                    isPasswordExist =true;
                    break;
               } 
            }
            for (User u : users) {
                if (u.getUserType().equalsIgnoreCase(user.getUserType())) {
                    isUserTypeExist = true;
                    break;
                }
            }
            IssueDetail detail = new IssueDetail();
            if(!isUserNameExist){
                detail.setSummary("user name");
                detail.setDescription("wrong user name entered");
            }
            if(!isPasswordExist){
                detail.setSummary(detail.getSummary()+" password");
                detail.setDescription(detail.getDescription()+" wrong password entered");
            }
            if(!isUserTypeExist){
                detail.setSummary(detail.getSummary() +" user type");
                detail.setDescription(detail.getDescription() +" wrong user type entered");
            }
            issueDetailService.save(detail);