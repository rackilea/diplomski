try (PreparedStatement ps=conn.prepareStatement(QueryMapper.SCHEDULE_APPLICANT_STATUS)) {
    ps.setString(1,schedule_id);
    try (ResultSet rs = ps.executeQuery()) {
        // or maybe if (rs.next())?
        while (rs.next()) { 
            Application applicationBean= new Application();
            System.out.println("ABC"+schedule_id);
            applicationBean.setScheduledProgramId(rs.getString(3)); 
            applicationBean.setStatus(rs.getString(2)); 
            applicationBean.setApplicantId(rs.getString(1)); 
            applicationList.add(applicationBean);
            applicationCount++;
        }
    }
} catch (SQLException sqlException) {
    log.error(sqlException.getMessage());
    System.out.println(sqlException.getMessage());
}