@Entity
@Indexed
class Resource {

    @Field(analyze=Analyze.NO)
    private String address; // has "xx-xx-xx" format
}