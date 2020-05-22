@Entity
@Table(name="cas_aws_role")
public class AWSRole implements Serializable{

@Column(name = "casAWSRolename")
private String casAWSRolename;

@Id
@GeneratedValue
@Column(name = "casAWSRoleId")
private int casAWSRoleId;

@Column(name = "casAWSRoleDisplayName")
private String casAWSRoleDisplayName;


@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="casAWSRoleId")
private Set<AWSPolicy> policies = new HashSet<AWSPolicy>();

// method to manage the bidirectional association
public void addToPolicies(AWSPolicy awsPolicy) {
    this.policies.add(awsPolicy);
    awsPolicy.setAWSRole(this);
}

@ManyToOne
@JoinColumn(name="casAWSRolesetId")
private AWSRoleset awsRoleset;

public AWSRoleset getAWSRoleset() {
    return awsRoleset;
}
public void setAWSRoleset(AWSRoleset awsRoleset) {
    this.awsRoleset = awsRoleset;
}


public Set<AWSPolicy> getPolicies() {
    return policies;
}
public void setPolicies(Set<AWSPolicy> policyList) {
    this.policies = policyList;
}

public int getCasAWSRoleId() {
    return casAWSRoleId;
}
public void setCasAWSRoleId(int casAWSRoleId) {
    this.casAWSRoleId = casAWSRoleId;
}

public String getCasAWSRolename() {
    return casAWSRolename;
}
public void setCasAWSRolename(String casAWSRolename) {
    this.casAWSRolename = casAWSRolename;
}


public String getCasAWSRoleDisplayName() {
    return casAWSRoleDisplayName;
}
public void setCasAWSRoleDisplayName(String casAWSRoleDisplayName) {
    this.casAWSRoleDisplayName = casAWSRoleDisplayName;
}

}


@Entity
@Table(name="cas_aws_policy")
public class AWSPolicy implements Serializable{

@Id
@GeneratedValue
@Column(name = "casAWSPolicyId")
private int casAWSPolicyId;

@Column(name = "casAWSPolicyName")
private String casAWSPolicyName;


@ManyToOne
@JoinColumn(name="casAWSRoleId")
private AWSRole awsRole;

public AWSRole getAWSRole() {
    return awsRole;
}
public void setAWSRole(AWSRole awsRole) {
    this.awsRole = awsRole;
}


public int getCasAWSPolicyId() {
    return casAWSPolicyId;
}
public void setCasAWSPolicyId(int casAWSPolicyId) {
    this.casAWSPolicyId = casAWSPolicyId;
}

public String getCasAWSPolicyName() {
    return casAWSPolicyName;
}
public void setCasAWSPolicyName(String casAWSPolicyName) {
    this.casAWSPolicyName = casAWSPolicyName;
}

}