public class CalendarServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws IOException {

        String something = req.getSession().getAttribute("merchant").toString(); //get info from your page (e.g. name) to search in query for database

        //Get the entire list of appointments available for specific merchant from database

        //Convert appointment to FullCalendar (A class I created to facilitate the JSON)
        List<FullCalendar> fullCalendar = new ArrayList<FullCalendar>();
        for (Appointment a : appointment) {
            String startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(a.getDate());
            startDate = startDate.replace(" ", "T");

            //Calculate End Time
            Calendar c = Calendar.getInstance();
            c.setTime(a.getDate());
            c.add(Calendar.MINUTE, 60);
            String endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime());
            endDate = endDate.replace(" ", "T");

            FullCalendar fc = new FullCalendar(startDate, endDate, a.getId(), a.getName() + " @ " + a.getPhone(), false);
            fullCalendar.add(fc);
        }

        //Convert FullCalendar from Java to JSON
        Gson gson = new Gson();
        String jsonAppointment = gson.toJson(fullCalendar);

        //Printout the JSON
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        try {
            resp.getWriter().write(jsonAppointment);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}