public boolean saveHighScore(Client c) throws SQLException {
    long totallvlexp = (long) (c.playerXP[0]) + (c.playerXP[1]) + (c.playerXP[2]) + (c.playerXP[3]) + (c.playerXP[4]) + (c.playerXP[5]) + (c.playerXP[6]) + (c.playerXP[7]) + (c.playerXP[8]) + (c.playerXP[9]) + (c.playerXP[10]) + (c.playerXP[11]) + (c.playerXP[12]) + (c.playerXP[13]) + (c.playerXP[14]) + (c.playerXP[15]) + (c.playerXP[16]) + (c.playerXP[17]) + (c.playerXP[18]) + (c.playerXP[19]) + (c.playerXP[20]); 
    int totallevell = (int) (c.getLevelForXP(c.playerXP[0]) + c.getLevelForXP(c.playerXP[1]) + c.getLevelForXP(c.playerXP[2]) + c.getLevelForXP(c.playerXP[3]) + c.getLevelForXP(c.playerXP[4]) + c.getLevelForXP(c.playerXP[5]) + c.getLevelForXP(c.playerXP[6]) + c.getLevelForXP(c.playerXP[7]) + c.getLevelForXP(c.playerXP[8]) + c.getLevelForXP(c.playerXP[9]) + c.getLevelForXP(c.playerXP[10]) + c.getLevelForXP(c.playerXP[11]) + c.getLevelForXP(c.playerXP[12]) + c.getLevelForXP(c.playerXP[13]) + c.getLevelForXP(c.playerXP[14]) + c.getLevelForXP(c.playerXP[15]) + c.getLevelForXP(c.playerXP[16]) + c.getLevelForXP(c.playerXP[17]) + c.getLevelForXP(c.playerXP[18]) + c.getLevelForXP(c.playerXP[19]) + c.getLevelForXP(c.playerXP[20]));
    boolean result = true;
    String updateSkillsSql = "UPDATE skills"
        + " SET `Attacklvl`=?,"
        + " `Attackxp`=?,"
        + " `Defencelvl`=?,"
        + " `Defencexp`=?,"
        + " `Strengthlvl`=?,"
        + " `Strengthxp`=?,"
        + " `Hitpointslvl`=?,"
        + " `Hitpointsxp`=?,"
        + " `Rangelvl`=?,"
        + " `Rangexp`=?,"
        + " `Prayerlvl`=?,"
        + " `Prayerxp`=?,"
        + " `Magiclvl`=?,"
        + " `Magicxp`=?,"
        + " `Cookinglvl`=?,"
        + " `Cookingxp`=?,"
        + " `Woodcuttinglvl`=?,"
        + " `Woodcuttingxp`=?,"
        + " `Fletchinglvl`=?,"
        + " `Fletchingxp`=?,"
        + " `Fishinglvl`=?,"
        + " `Fishingxp`=?,"
        + " `Firemakinglvl`=?,"
        + " `Firemakingxp`=?,"
        + " `Craftinglvl`=?,"
        + " `Craftingxp`=?,"
        + " `Smithinglvl`=?,"
        + " `Smithingxp`=?,"
        + " `Mininglvl`=?,"
        + " `Miningxp`=?,"
        + " `Herblorelvl`=?,"
        + " `Herblorexp`=?,"
        + " `Agilitylvl`=?,"
        + " `Agilityxp`=?,"
        + " `Thievinglvl`=?,"
        + " `Thievingxp`=?,"
        + " `Slayerlvl`=?,"
        + " `Slayerxp`=?,"
        + " `Farminglvl`=?,"
        + " `Farmingxp`=?,"
        + " `Runecraftlvl`=?,"
        + " `Runecraftxp`=?"
        + " WHERE playerName = ?";
    //do similar for the other queries...

    //not needed since JDBC 4, noted since you're using Java 7
    //Class.forName("com.mysql.jdbc.Driver").newInstance();
    try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/highscores","root","root")) {
        //when storing multiple data, it's better to use a transaction
        con.setAutoCommit(false);
        try(PreparedStatement pstmt = con.prepareStatement(updateSkillsSql);
            //declare the other PreparedStatements for each update sql statement here...
            ) {
            //do something like this for every PreparedStatement
            setParameters(pstmt,
                c.playerLevel[0], c.playerXP[0],
                c.playerLevel[1], c.playerXP[1],
                c.playerLevel[2], c.playerXP[2],
                c.playerLevel[3], c.playerXP[3],
                c.playerLevel[4], c.playerXP[4],
                c.playerLevel[5], c.playerXP[5],
                c.playerLevel[6], c.playerXP[6],
                c.playerLevel[7], c.playerXP[7],
                c.playerLevel[8], c.playerXP[8],
                c.playerLevel[9], c.playerXP[9],
                c.playerLevel[10], c.playerXP[10],
                c.playerLevel[11], c.playerXP[11],
                c.playerLevel[12], c.playerXP[12],
                c.playerLevel[13], c.playerXP[13],
                c.playerLevel[14], c.playerXP[14],
                c.playerLevel[15], c.playerXP[15],
                c.playerLevel[16], c.playerXP[16],
                c.playerLevel[17], c.playerXP[17],
                c.playerLevel[18], c.playerXP[18],
                c.playerLevel[19], c.playerXP[19],
                c.playerLevel[20], c.playerXP[20],
                c.playerName);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(String.format("There's a problem when saving the data of  player %s.", c.playerName));
            e.printStackTrace(System.out);
            con.rollback();
            result = false;
        }
        if (result) {
            con.commit();
            con.setAutoCommit(true);
        }
    } catch (Exception e) {
        System.out.println(String.format("There's a problem when saving the data of  player %s.", c.playerName));
        e.printStackTrace(System.out);
        result = false;
    }
    return result;
}

//created method to add parameters despite its type    
private void setParameters(PreparedStatement pstmt, Object ... args) {
    int i = 1;
    for (Object arg : args) {
        pstmt.setObject(i++, arg);
    }
}