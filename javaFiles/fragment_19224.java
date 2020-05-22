@WebServlet("/products")
public class ProductsServlet extends HttpServlet {

    @EJB
    private ProductService productService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.list();
        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/products.jsp").forward(request, response);
    }

}