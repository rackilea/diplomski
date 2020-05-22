@Embedded
    @AttributeOverrides({
        @AttributeOverride(name="ip1", column=@Column(name="companyTestDetails_ip1")),
        @AttributeOverride(name="AS2ID1", column=@Column(name="companyTestDetails_as2id1")),
        @AttributeOverride(name="url", column=@Column(name="companyTestDetails_url")),
        @AttributeOverride(name="AS2ID2", column=@Column(name="companyTestDetails_as2id2")),
        @AttributeOverride(name="port", column=@Column(name="companyTestDetails_port")),
        @AttributeOverride(name="ip2", column=@Column(name="companyTestDetails_ip2")),
        @AttributeOverride(name="userId", column=@Column(name="companyTestDetails_userId")),
        @AttributeOverride(name="password", column=@Column(name="companyTestDetails_password")),
        @AttributeOverride(name="AS2Software", column=@Column(name="companyTestDetails_as2software"))
})
private AS2Details companyTestDetails;