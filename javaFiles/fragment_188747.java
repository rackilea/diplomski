@WebServlet("/CarTest")
public class CarTest extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Car> list = new ArrayList<Car>();
        list.add(new Car("car1", "brand1"));
        list.add(new Car("car2", "brand2"));
        list.add(new Car("car3", "brand3"));
        list.add(new Car("car4", "brand4"));
        request.setAttribute("cars", list);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}