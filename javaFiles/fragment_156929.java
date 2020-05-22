@Id
@Column
private String fkParamClassID;
public String getFKParamClassID(){ return fkParamClassID; }
public void setFKParamClassID (String value) { fkParamClassID = value; }

@Id
@Column
private String fkParamID;
public String getFKParamID(){ return fkParamID; }
public void setFKParamID (String value) { fkParamID = value; }

//---------------------------------------------------------------------------------------------
// Join columns based on key columns.
//---------------------------------------------------------------------------------------------

@ManyToOne
@JoinColumn(name = "fkParamClassID", referencedColumnName = "ID", insertable = false, updatable = false)
private ParameterClass parameterClass;

@ManyToOne
@JoinColumn(name = "fkParamID", referencedColumnName = "ID", insertable = false, updatable = false)
private Parameter parameter;