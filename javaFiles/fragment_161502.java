try {
    String sql = "UPDATE course SET category = ?, course_code = ? ,course_type = ? ,course_name = ?, "
            + "attach_file=? where course_code = ? ";

    pst = conn.prepareStatement(sql);
    pst.setString(1, add1);
    pst.setString(2, add2);
    pst.setString(3, add3);
    pst.setString(4, add4);
    pst.setString(5, add5);
    pst.setString(6, add2);
    pst.executeUpdate JOptionPane.showMessageDialog(null, "Successfully updated.");

} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}