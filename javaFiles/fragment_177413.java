public static void main(String[] args)
{

    List<String> firstSchema =Arrays.asList(DataTypes.createStructType(ConfigConstants.firstSchemaFields).fieldNames());
    List<String> secondSchema = Arrays.asList(DataTypes.createStructType(ConfigConstants.secondSchemaFields).fieldNames());


    if(schemasHaveTheSameColumnNames(firstSchema,secondSchema))
    {
        System.out.println("Yes, schemas have the same column names");
    }else
    {
        System.out.println("No, schemas do not have the same column names");
    }
}

private static boolean schemasHaveTheSameColumnNames(List<String> firstSchema, List<String> secondSchema)
{
    if(firstSchema.size() != secondSchema.size())
    {
        return false;
    }else 
    {
        for (String column : secondSchema)
        {
            if(!firstSchema.contains(column))
                return false;
        }
    }
    return true;
}