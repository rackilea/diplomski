String sql = "SELECT Publisher.Name, Book.Title, ShopOrder.OrderDate, SUM(OrderLine.Quantity) AS No_Books, "
        + " SUM(OrderLine.UnitSellingPrice * Orderline.Quantity) AS Total_Price"
        + " FROM Publisher, Book, OrderLine, ShopOrder"
        + " WHERE OrderLine.BookID = Book.BookID AND ShopOrder.ShopOrderID = OrderLine.ShopOrderID AND Publisher.PublisherID = Book.PublisherID AND Publisher.PublisherID = " + id
        + " GROUP BY book.title, publisher.name, ShopOrder.OrderDate"
            + " ORDER BY ShopOrder.OrderDate, Book.Title";