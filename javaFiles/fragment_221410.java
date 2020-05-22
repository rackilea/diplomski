/**
     * Generates DB column and java Domain class property mapping
     * 
     * @param pInputClassName
     *                       java Domain class, fully qualified name(package+java class)
     * @return
     *                       Map<String,ColumnMappingDTO>, mapping of DB column and Java Doamin class property
     * @throws Exception
     *                       if pInputClassName is not loaded properly
     */
    private static Map<String, ColumnMappingDTO> initColumnMappings(String pInputClassName) throws Exception {

        Map<String, ColumnMappingDTO> outMappingDetails = new HashMap<String, ColumnMappingDTO>();

        try {

            for (Field vField : getFields(pInputClassName)) {
                for (Annotation vAnnotation : vField.getDeclaredAnnotations()) {
                    if (vAnnotation instanceof Column) {
                        ColumnMappingDTO vColumnMappingDTO = createColumnMapping(vField, (Column) vAnnotation);
                        outMappingDetails.put(vColumnMappingDTO.getColumnName(), vColumnMappingDTO);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("caught Exception in initColumnMappings() as  " + ex);
            throw ex;
        }

        return outMappingDetails;
    }


    /**
     * @param vField
     * @param vAnnotation
     * @return
     */
    private static ColumnMappingDTO createColumnMapping(Field vField, Column vAnnotation) {
        ColumnMappingDTO vColumnMappingDTO = new ColumnMappingDTO();
            vColumnMappingDTO.setPropertyName(vField.getName());
            vColumnMappingDTO.setColumnName(vAnnotation.name());
        return vColumnMappingDTO;
    }


    /**
     * @param pInputClassName
     * @return
     * @throws ClassNotFoundException
     */
    private static Field[] getFields(String pInputClassName) throws ClassNotFoundException {
        //try loading Domain Object Class
        return Class.forName(pInputClassName).getDeclaredFields();
    }



    /**
     * Executes sql passed inform of PreparedStatement inPstmt and generated List genere as String pDomainClassName
     * 
     * @param inPstmt
     *               Sql to be executed inform of PreparedStatement
     * @param pDomainClassName
     *               fully qualified Class name of DTO
     * @return
     *               Object, later to be type casted to List<pDomainClassName>
     * @throws Exception
     *               When Mapping is not missing or done wrong 
     * 
     */

    public static Object executeQuery(PreparedStatement inPstmt, String pDomainClassName) throws SQLException, Exception {
        return executeQuery(inPstmt, Class.forName(pDomainClassName));
    }

    public static <T> List<T>  executeQuery(PreparedStatement inPstmt, Class<T> domainClass) throws SQLException, Exception {

        List<T> outResultList = new ArrayList<T>();
        ResultSet mRSet = null;
        try {

            // generate DB Column and Domain Class property mapping
            Map<String, ColumnMappingDTO> mMappingDetailsMap = initColumnMappings(domainClass.getName());

            // execute sql
            mRSet = inPstmt.executeQuery();

            if (mRSet == null) {
                return Collections.EMPTY_LIST;
            }

            List<String> mColumnNamesList = getColumnNameList(mRSet);


            while (mRSet.next()) {
                List<ColumnValueDTO> mColumnValuesList = new ArrayList<ColumnValueDTO>();

                for (String columnHeader : mColumnNamesList) {

                    if (mMappingDetailsMap.containsKey(columnHeader)) {
                        ColumnValueDTO mColumnValueDTO = new ColumnValueDTO();
                            mColumnValueDTO.setPropertyName(mMappingDetailsMap.get(columnHeader).getPropertyName());
                            mColumnValueDTO.setPropertyValue(mRSet.getString(mMappingDetailsMap.get(columnHeader).getColumnName()));
                        mColumnValuesList.add(mColumnValueDTO);
                    }
                }

                //
                T domainObj = createDomainObject(mColumnValuesList, domainClass);

                // Add Object to out List
                outResultList.add(domainObj);
            }
        } catch (Exception ex) {
            System.out.println(" caught in executeQuery() " + ex);
            throw ex;
        } finally {

            // release resources
            try {
                mRSet.close();
            } catch (SQLException e) {
                System.out.println(" caught in Exception while closing ResultSet " + e);
                throw e;
            }

        }
        return outResultList;
    }


    /**
     * @param mColumnNamesList
     * @param mRSet
     * @return 
     * @throws SQLException
     */
    private static List<String> getColumnNameList(ResultSet mRSet) throws SQLException {

        ResultSetMetaData mRsetMt = mRSet.getMetaData();

        if(mRsetMt == null){
            return Collections.EMPTY_LIST;
        }

        List<String> mColumnNamesList = new ArrayList<String>();

        // generate SELECT columns list
        for (int i = 0; i < mRsetMt.getColumnCount(); i++) {
            mColumnNamesList.add(mRsetMt.getColumnName(i + 1));
        }

        return mColumnNamesList;
    }


    private static Object createDomainObject(List<ColumnValueDTO> columnValuesList, String vDoaminClass) throws Exception {

        Class<?> domainClassObj = Class.forName(vDoaminClass);
        return createDomainObject(columnValuesList, domainClassObj);

    }

    private static <T> T createDomainObject(List<ColumnValueDTO> columnValuesList, Class<T> domainClassObj) throws Exception {

        T domainObj = null;

        try {

            domainObj = domainClassObj.newInstance();

            for (ColumnValueDTO columnDTO : columnValuesList) {

                if (columnDTO == null) {
                    continue;
                }

                Field domainDataField = domainClassObj.getDeclaredField(columnDTO.getPropertyName());
                    domainDataField.setAccessible(true);

                Object valueByType = parseValueByType(columnDTO.getPropertyValue(), domainDataField.getType());
                domainDataField.set(domainObj, valueByType);
            }

        } catch (Exception e) {
            System.out.println(" Caught " + e.getClass().getSimpleName() + " in createDomainObject() " + e);
            throw e;
        }

        return domainObj;
    }

    private static Object parseValueByType(String value, Type type) throws Exception{

        if(value == null) {
            return null;
        }

        try{

            if(Integer.TYPE.equals(type)){
                return Integer.parseInt(value);
            }

            if(Double.TYPE.equals(type)){
                return Double.parseDouble(value);
            }

            if(Float.TYPE.equals(type)){
                return Float.parseFloat(value);
            }

            if(Short.TYPE.equals(type)) {
                return Short.parseShort(value);
            }

            if(Long.TYPE.equals(type)) {
                return Long.parseLong(value);
            }

            if(java.sql.Timestamp.class.equals(type)) {
                return java.sql.Timestamp.valueOf(value);
            }

            if(java.sql.Date.class.equals(type)) {
                return java.sql.Date.valueOf(value);
            }

            if(String.class.equals(type)) {
                return value; 
            }

            if(Character.TYPE.equals(type)) {
                if(value.length() == 1) {
                    return value.charAt(0);
                }

                if(value.length() == 0) {
                    return '\0';
                }
                throw new IllegalStateException("");
            }

        }catch(Exception ex){
            System.out.println(" Caught Exception in getValueByType() "+ex);
            throw ex;
        }

        throw new IllegalArgumentException("Could not find the resolver for type " + type);
    }


     public static class ColumnValueDTO implements Serializable {

            private String propertyName;
            private String propertyValue;

            private static final long serialVersionUID = -4915109169715618102L;

            /**
             * @return the propertyName
             */
            public String getPropertyName() {
               return propertyName;
            }
            /**
             * @param propertyName the propertyName to set
             */
            public void setPropertyName(String propertyName) {
                 this.propertyName = propertyName;
            }
            /**
             * @return the propertyValue
             */
            public String getPropertyValue() {
                return propertyValue;
            }
            /**
             * @param propertyValue the propertyValue to set
             */
            public void setPropertyValue(String propertyValue) {
                this.propertyValue = propertyValue;
            }

            public String toString(){
                return "Property ::  "+this.propertyName+"   Value :: "+this.propertyValue;
            }


        }


     public static class ColumnMappingDTO {

         private String columnName;
         private String propertyName;
         private String dataType;

         /**
          * @return the columnName
          */
         public String getColumnName() {
             return columnName;
         }
         /**
          * @param columnName the columnName to set
          */
         public void setColumnName(String columnName) {
             this.columnName = columnName;
         }
         /**
          * @return the dataType
          */
         public String getDataType() {
             return dataType;
         }
         /**
          * @param dataType the dataType to set
          */
         public void setDataType(String dataType) {
             this.dataType = dataType;
         }
         /**
          * @return the propertyName
          */
         public String getPropertyName() {
             return propertyName;
         }
         /**
          * @param propertyName the propertyName to set
          */
         public void setPropertyName(String propertyName) {
             this.propertyName = propertyName;
         }

         public String toString(){

             return "Database Column :: "+this.columnName+"  Java Property :: "+this.propertyName+"   Java Datatype :: "+this.dataType;
         }
     }

     private static class Column {

        /**
         * @return
         */
        public String name() {
            // TODO Auto-generated method stub
            return null;
        }

     }