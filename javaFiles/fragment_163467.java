@WebServlet("/jobs") // only with Servlet 3.0  
public class SchedulerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get input parameter
        String time = request.getParameter("time");
        // validate that it is not null/empty and is valid time (custom method)
        if (time != null && !time.isEmpty() && isValidTime(time)) {
            int jobNo = ... // generate job no
            YourJobScheduler scheduler = ... // get scheduler
            JobDetails jobDetails = scheduler.scheduleLoad(time, jobNo); // maybe this return details of the scheduled job

            request.setAttribute("jobDetails", jobDetails);             
            // do something with response
            request.getRequestDispatcher("/WEB-INF/ShowJobDetails.jsp").forward(request, response);
        }

        // missing input parameter, so send error 
    }
}