package cart;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Product
 */
@WebServlet("/Product")
public class Product extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDataBean pDataBean = new ProductDataBean();

    public Product() {
        super();        
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Product> products;
        try {
            products = pDataBean.getProductList();  // Obtain all products.
            request.setAttribute("products", products); // Store products in request scope.
            request.getRequestDispatcher("/test.jsp").forward(request, response); // Forward to JSP page to display them in a HTML table.
        } catch (SQLException e) {                  
            e.printStackTrace();
        }
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {  
        String movie = req.getParameter("movie");
        String rating = req.getParameter("rating");
        String year = req.getParameter("year");
        Double price = Double.valueOf(req.getParameter("price"));

        if(movie!=null && rating!=null && year!=null && price!=null)
            try {
                ProductDataBean.addRecord(new DVD(movie, rating, year, price));
            } catch (SQLException e) { 
                e.printStackTrace();
            }
        doGet(req, resp);
    }

}