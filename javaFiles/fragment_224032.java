@Column(name = "language_id", insertable = false, updatable = false)
private Long languageId;

@NotNull
@OneToOne
@JoinColumn(name = "language_id")
private Language language;

public void setLanguage(Language language) {
    this.languageId = language.getId();
    this.language = language;
}