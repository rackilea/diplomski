@Fields({
   @Field(name = "owningOrganization_untokenized", index = Index.UN_TOKENIZED),
   @Field(name = "owningOrganization", index = Index.TOKENIZED, store = Store.YES
   }
)
public Organization getOwningOrganization(){
}