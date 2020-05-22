Map<String,Object> inParameters = new HashMap<>();
                //Its a mandatory field , so passing it as null.
                inParameters.put(DAOConstants.ERROR_MSG, null);
                inParameters.put(DAOConstants.START_DATE, converJavaToSqlDate(startDate));
                inParameters.put(DAOConstants.END_DATE, converJavaToSqlDate(endDate));
                inParameters.put(DAOConstants.PARAM1, par1);
                inParameters.put(DAOConstants.PARAM2, par2);
                inParameters.put(DAOConstants.PARAM3, par3);

                Map<String, Object> results = super.execute(inParameters);