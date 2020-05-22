public class VehicleServlet extends HttpServlet {

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

    String path = req.getPathInfo();

    //gets what comes after "/" (I've not tested it)
    String strVehicleId = path.substring(path.indexOf('/'));

    int vehicleId = Integer.parseInt(strVehicleId);
    //finds the vehicle
    Vehicle v = vehicleDao.findByPrimaryKey(vehicleId);

    //sends the image
    resp.setContentType("image/jpg");
    BufferedOutputStream out = new BufferedOutputStream(resp.getOutputStream());
    out.write(v.getImage());
    out.close();

}