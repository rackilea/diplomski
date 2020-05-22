@NotNull    
@Enumerated(EnumType.ORDINAL)
@Column(name = "LANGUAGEID", insertable=false, nullable = false)
private LanguageEnum language;

@NotNull    
@ManyToOne
@JoinColumn(name="MESSAGEID", insertable=false, nullable = false)
private Message message;

@PrePersist
private void prePersist(){
    if (getId() == null){
        MessageDescPK id = new MessageDescPK();
        //the way this enum is persisted is EnumType.ORDINAL
        id.setLanguage(getLanguage().ordinal());
        id.setMessage(getMessage().getId());
        this.setId(id);
    }
}