//AvailableOption.java
@ManyToMany(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
@JoinTable(
  name = "AvailOptionPlanTypeAssoc",
  joinColumns = { @JoinColumn(name = "OptionId"),
                  @JoinColumn(name="SourceApplication")},
  inverseJoinColumns=@JoinColumn(name="PlanTypeCd"))
List<PlanType> planTypes = new ArrayList<PlanType>();

//PlanType.java
@ManyToMany(
    mappedBy = "planTypes"
)
List<AvailableOption> options = new ArrayList<AvailableOption>();