out.println("<html>");
out.println("<head>");
out.println("<script>");
out.println("alert('Booking Added Successfully.\nYour Booking Reference Number Is" + booking.getBookingID() + "')"); //You should remove the brackets
out.println("</script>");
out.println("<META HTTP-EQUIV= Refresh CONTENT=0;URL=BookNewVehicle.jsp>");
out.println("</head>");
out.println("</html>");