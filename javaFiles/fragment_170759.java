@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="Languages_id", nullable=false, insertable=false, updatable=false)
public Languages getLanguages() {barcode

    return this.languages;
}