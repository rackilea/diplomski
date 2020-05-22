@NamedQuery(name="account.queryName",
   query="select acct from Account ...",
   hints={
       @QueryHint(name="org.hibernate.cacheable",
       value="true")
   }     
})