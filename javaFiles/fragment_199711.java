@Basic@Column(name = "creator_id_conversation", insertable=false, updatable=false)
    private int creatorIdConversation;

    @ManyToOne
    @JoinColumn(name = "creator_id_conversation"
              , referencedColumnName = "id_user", nullable = false)})
    private TblUsers tblUsersByCreatorIdConversation;