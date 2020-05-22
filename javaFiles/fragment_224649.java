@Embedded
  @AttributeOverrides({ @AttributeOverride(name = "storage.size", column = @Column(name ="storage_low")) })
  private StorageSizeTBPerMonth limitLow;
  // ...
  @Embedded
  @AttributeOverrides({ @AttributeOverride(name = "storage.size", column = @Column(name = "storage_high")) })
  private StorageSizeTBPerMonth limitHigh;