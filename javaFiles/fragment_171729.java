if (rs.next()) {
    // At least one record returned
    do {
        if (rs.getString(1).equalsIgnoreCase("0")) {
            // Step2
        }

        if (rs.getString(1).equalsIgnoreCase("1")) {
            // Step3
        }
    } while (rs.next());
} else {
    // No records returned
}