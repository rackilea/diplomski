} catch (SQLException s) {
        System.out.println("SQL Error: " + s.toString() + " " 
                + s.getErrorCode() + " " + s.getSQLState());
        // and show us the stacktrace
        s.printStackTrace();
    } catch (Exception e) {
        System.out.println("Error: " + e.toString() + e.getMessage());
        // and show us the stacktrace
        e.printStackTrace();
    }