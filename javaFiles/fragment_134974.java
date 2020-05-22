private transient int id;
private int record_id;
private String cid, amount, accountbook, asset, createdAt, recordType, remark, category, user;
private String record_cid, record_amount, record_category, record_book, record_type, record_remark, record_createdAt, record_asset, record_user;

//Declare Constructor
public Record(String amount, String accountbook, String asset, String createdAt, String recordType, String remark, String category, String user) {
    this.amount = amount;
    this.accountbook = accountbook;
    this.asset = asset;
    this.createdAt = createdAt;
    this.recordType = recordType;
    this.remark = remark;
    this.category = category;
    this.user = user;
}