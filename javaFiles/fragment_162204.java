String ruleGrpId = null;
    int finalRuleID = 0;
    String saveRule1 = "INSERT INTO ..";
    String saveRule2 = "INSERT INTO ";
    String saveRule3 = "select ..._name = ?";

    if (objSomeRule.getRule() == 0) {
        try (PreparedStatement ps1 = con.prepareStatement(saveRule1)) {
            ps1.setString(1, ruleId);
            ps1.executeUpdate();
        }
        try (PreparedStatement ps2 = con.prepareStatement(saveRule2)) {
            ps2.setInt(1, ruleID_2);
            ps2.setString(2, ruleID_3);

            try (ResultSet rs2 =  ps2.executeQuery()) {

                if (rs2.next()) {
                    finalRuleID = rs2.getInt(1);
                } else {
                    try (Preparedstatement ps3 = con.prepareStatement(saveRule3)) {
                        ps3.setString(1, ruleID_4);
                        //complains here
                        try (ResultSet rs3 =  ps3.executeQuery()) {
                            if (rs3.next()) {
                                finalRuleID = rs3.getInt("rulegroup_id");
                            }
                        }
                    }
                }
            }
            objSomeRule.setRuleID(finalRuleID);
        }
    }