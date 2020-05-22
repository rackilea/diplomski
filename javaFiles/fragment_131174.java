Double result = null;
     Double totalValue = null;
     Double totalSales = null;
      ...

      PreparedStatement ps = conn.prepareStatement("select Sum(Total_Sales) as Sales_Total, Sum(Total_Value) as Value_Total, SUM(Total_Sales - Total_Value) As Result from DailyAnalysis where Date1 BETWEEN ? AND ? ");
            ps.setDate(1,fromDate)
            ps.setDate(2,toDate)
            ResultSet rs = ps.executeQuery();

            //Query should only return one or zero result hence the if statement
            if (rs.next())
            {  
               //Define variables at the top, if you want to have access outside the if block scope
               totalValue = rs.getDouble("Value_Total");
               totalSales = rs.getDouble("Sales_Total");
               result = rs.getDouble("Result");
            }