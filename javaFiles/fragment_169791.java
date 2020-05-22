ArrayList<String> list = new ArrayList<String>();
            out.println("HI GROUP MEMBER");
            String query="Select GNAME from tbGroup";
            ps = con.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
                list.add(rs.getString("GNAME"));
            }
            request.setAttribute("res1",list);
            RequestDispatcher rd= context.getRequestDispatcher("GroupLoginScreen.jsp");
            rd.forward(request, response);