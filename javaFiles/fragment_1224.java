cx = getConnection();
    st = cx.createStatement();   // create sql statement
    String stmt1 = "update ta_rule_pakt set description = 'Syed Test 1', active_flag = '1' where paktpk = '7'";
    String stmt2 = "update ta_rule_break_header_paky with (rowlock) set start_time = 14400, end_time = 32364, break_code =  17, break_type = 1  where pakt_ta_rule = '7' and step = 1";
    String stmt3 = "delete from ta_rule_break_detail_pakz with (rowlock) where paky_ta_rule_break_header = 2";
    String stmt4 = "insert into ta_rule_break_detail_pakz with (rowlock) (pakzpk, paky_ta_rule_break_header, pay_code)  values(14,2, 17 )";
    String stmt5 = "insert into ta_rule_break_detail_pakz with (rowlock) (pakzpk, paky_ta_rule_break_header, pay_code)  values(15,2, 14 )";
    st.execute(stmt1);
    st.execute(stmt2);
    st.execute(stmt3);
    st.execute(stmt4);
    st.execute(stmt5);