else if(!captcha.isCorrect(answer)) {
                            request.setAttribute("captchaMismatch","Captcha does not match");
                            request.getRequestDispatcher("index.jsp").forward(request, response);

                        }
                  else {
                        String sql1 = "SELECT password FROM accounts WHERE username=?";//getting username
            PreparedStatement ps=con.prepareStatement(sql1);
            ps.setString(1,usernameInput);

            ResultSet rs = ps.executeQuery();
               //if row exist means username there in table
              if(rs.next())
                {
                    //getting password
                    String pass = rs.getString("password");
                    //checking if pass is not equal
                  if(!pass.equals(passwordEnc)){
                            request.setAttribute("loginError","Wrong password!");
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                        }
                      }else{

                        request.setAttribute("loginError","Wrong username");
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                     }

             }