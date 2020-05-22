for (Object[] objects : result) {
                DocumentBean documentInfo=(DocumentBean)objects[0];
                TableInfoBean userInfo=(TableInfoBean)objects[1];
                System.out.println("Kelner="+userInfo.getName()+"\t Masa="+documentInfo.getNote());
                TableInfoBean zaedno = new TableInfoBean();
                zaedno.setLastname(documentInfo.getNote());
                zaedno.setName(userInfo.getName());
                userInformation.add(zaedno);
         }