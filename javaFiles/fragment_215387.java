private String transId;
private String portfolio;
private String portfolioCcy;
private String transRef;
private String adjustmentType;

@DateTimeFormat(pattern = "dd/MM/yyyy")
private LocalDate transDate;
private String debitCredit;
private String investCategory;
private String custodian;
private String recRemarks;
private RecStatus recStatus;
private Boolean isUploaded=true;