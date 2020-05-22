chnage 

@NonNull
@PrimaryKey
@SerializedName("_id") // key does not match with response key
private String _id;


to 


@NonNull
@PrimaryKey
@SerializedName("id")
private String _id;