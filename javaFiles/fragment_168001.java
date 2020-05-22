if(db.loginCheck(userName, password))
            {
                response.getWriter().write("1");
            }else
            {
                 greetings = "Invalid Username/Password";
                 response.setContentType("text/plain");
                response.getWriter().write(greetings);

            }