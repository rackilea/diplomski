@Column(name = "DESCRIPTOR")
private String                  descriptorAcronym       = null;
private transient Descriptor    descriptor              = null;
public Descriptor getDescriptor() {
    return descriptor;
}
public void setDescriptor(Descriptor desc) {
    this.descriptor = desc;
    this.descriptorAcronym = desc != null ? desc.acronym : null;
}
public String getDescriptorAcronym() {
    return descriptorAcronym;
}
public void setDescriptorAcronym(String desc) {
    this.descriptorAcronym = desc;
    this.descriptor = desc != null ? Descriptor.valueOf(desc) : null;
}
@PostLoad
private void syncDescriptor() {
    this.descriptor = this.descriptorAcronym != null ? Descriptor.valueOf(this.descriptorAcronym) : null;
}