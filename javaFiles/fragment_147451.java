<% car.setCars();
                for (int i = 0; i < car.getTotalNumberOfCars(); i++) {
                   out.println("<a  class=\"car-link\" href=\"model.jsp?id="+ car.cars[i].getCarId()+"\" id"+ "=\"" +car.cars[0].getCarId() + "\">");
                   out.println("<div class=\"col-sm-6 col-md-3\"> ");
                   out.println("<div class=\"thumbnail parts\">");
                   out.println("<img src=\""+ car.getCars()[i].getCarImg()+ "\" alt=\"...\""+ " height=\"300\">");
                   out.println("<div class=\"caption\"");
                   out.println("<h1>"+car.getCars()[i].getCarName()+"</h1>");
                   out.println("<p>"+car.getCars()[i].getCarDesc()+"</p>");
                   out.println("</div>");
                   out.println("</div>");
                   out.println("</a>");
                   out.println("</div>");

                }
            %>