public class Item {
private String id
private String personID;

@DynamoDBHashKey
@DynamoDBGeneratedUuid(DynamoDBAutoGenerateStrategy.CREATE)
public String getId(){
    return id;
}

@DoNotTouch
@DynamoDBAttribute
@DynamoDBIndexHashKey(globalSecondaryIndexName = "personID-index")
public String getPersonID() {
    return personID;
}
};