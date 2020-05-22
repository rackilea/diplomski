@NamedQueries({
        @NamedQuery(
                name = "Contract.allContractsByOwner",
                query = "SELECT c FROM Contract c WHERE c.owner.id = :ownerId"
        )
})