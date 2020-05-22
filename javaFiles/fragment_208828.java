@DynamoDBAttribute
@DynameDBIndexHashKey(globalSecondaryIndexName = "name_index")
@DynameDBIndexRangeKey(globalSecondaryIndexName = "owner_index")
private String itemName;


@DynamoDBAttribute
@DynameDBIndexHashKey(globalSecondaryIndexName = "owner_index")
private String itemOwner