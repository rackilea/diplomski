@OneToOne
@JoinColumns({
    @JoinColumn(name="ID_ESCALA",referencedColumnName="ID_ESCALA",insertable=false,updatable=false),
    @JoinColumn(name="ANO",referencedColumnName="ANO",insertable=false,updatable=false),
    @JoinColumn(name="MES",referencedColumnName="MES",insertable=false,updatable=false)
})
private PoaUpa poaUpa;