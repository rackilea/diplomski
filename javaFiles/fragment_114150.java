if (action.equalsIgnoreCase("edit")) {        
          String username = request.getParameter("username").trim();
          if (request.getParameterMap().containsKey("roles")) {
                        String roleList = request.getParameter("roles").trim();
                        String[] role = splitRoles(roleList);
                        dao.deleteRoles(username); // first delete roles                                                  
                       for(int i = 0;i<role.length;i++){
                           String currentRole = role[i];  
                           dao.addUserRoles(username,currentRole); // then add roles
                       }
          }

  }