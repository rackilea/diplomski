final RowMapper managerMapper = new BeanPropertyRowMapper(Manager.class);
    final RowMapper employeeMapper = new BeanPropertyRowMapper(Employee.class);
    final RowMapper contractorMapper = new BeanPropertyRowMapper(Contractor.class);

    RowMapper rm = new RowMapper()
    {
        @Override
        public Object mapRow(ResultSet rs, int rowNum)
            throws SQLException
        {
            int employeeType = rs.getInt("type");
            switch (employeeType)
            {
                case 1:
                    return managerMapper.mapRow(rs, rowNum); 

                case 2:
                    return employeeMapper.mapRow(rs, rowNum);

                case 3:
                    return contractorMapper.mapRow(rs, rowNum);

                default:
                    break;

            }
        }
    };