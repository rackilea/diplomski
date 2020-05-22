public Column makeJoinConditional(Dataset<Row> df1, Dataset<Row> df2, List<String> columnNames, Column c)  {

        if (c==null) {
            String  top = columnNames.get(0);
            columnNames.remove(0);
            Column first = df1.col(top).equalTo(df2.col(top));

            return makeJoinConditional(df1,df2, columnNames,first);

        } else {

            if (columnNames.size()==0) {
                return c;
            } else {
                String  top = columnNames.get(0);
                columnNames.remove(0);
                Column next = c.and( df1.col(top).equalTo(df2.col(top)) );
                return makeJoinConditional(df1,df2, columnNames,next);
            }
        }
    }

    public Dataset<Row> joinDataFrames(Dataset<Row> df1, Dataset<Row> df2, List<String> columns) {
        Column joinCols = makeJoinConditional(df1,df2,columns,null);
        return df1.join(df2,joinCols);
    }