while(rs.next()) // where the error occurs
    {
        PersonalBean pb = new PersonalBean();
        UserDonationBean ud = new UserDonationBean();
        ud.setDonationID(rs.getInt("DonationID"));
        ud.setAmount(rs.getDouble("Amount"));
        ud.setDateDonated(rs.getDate("DateDonated"));
        ud.setUsername(rs.getString("Username"));
        rs2 = st.executeQuery("SELECT Lastname, Firstname FROM PersonalInformation WHERE Username = '" + rs.getString("Username") + "'");
        rs2.next();
        pb.setLastName(rs2.getString("Lastname"));
        pb.setFirstName(rs2.getString("Firstname"));
        u.add(ud);
        p.add(pb);
    }
}