declareParameter(new SqlOutParameter("returnValue", Types.VARCHAR)); 
        declareParameter(new SqlParameter("par_login_id", Types.VARCHAR));
        declareParameter(new SqlParameter("par_old_user_id", Types.NUMERIC));
        declareParameter(new SqlParameter("par_new_user_id", Types.NUMERIC));
        declareParameter(new SqlParameter("par_user_profile_id", Types.NUMERIC));
        compile();