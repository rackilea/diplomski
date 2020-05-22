@OneToOne
  @JoinTable(name="TTR_POA_UPA",
    joinColumns = {
      @JoinColumn(name="ANO", insertable=false, updatable=false),
      @JoinColumn(name="ID_ESCALA", insertable=false, updatable=false),
      @JoinColumn(name="MES", insertable=false, updatable=false)          
    },
    inverseJoinColumns = {
      @JoinColumn(name="ANO", insertable=false, updatable=false),
      @JoinColumn(name="ID_ESCALA", insertable=false, updatable=false),
      @JoinColumn(name="MES", insertable=false, updatable=false)
    }     
  )
private PoaUpa poaUpa;