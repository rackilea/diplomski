//====== You need to add the end date to the line below as one of this methods inputs so it accepts the call from ActiveContractTabController =====//
public ActiveContractor(String _contractor, String _natureOfContract, String _user_dept, int _value, int _valueRate, LocalDate _start_date, LocalDate _end_date, Integer _contractDuration, String _remarks, String _contractType) {
    this._contractor = _contractor;
    this._natureOfContract = _natureOfContract;
    this._user_dept = _user_dept;
    this._value = _value;
    this._valueRate = _valueRate;
    this._start_date = _start_date;
    //====== You need to add the end date here =====//
    this._end_date = _end_date;
    this._contractDuration = _contractDuration;
    this._remarks = _remarks;
    this._contractType = _contractType;
}


//====== You need to add the end date to the line below as one of this methods inputs so it accepts the call from ActiveContractTabController =====//
public ActiveContractor(StringProperty contractor, StringProperty natureOfContract, StringProperty user_dept, IntegerProperty value, IntegerProperty valueRate, SimpleObjectProperty<LocalDate> start_date, SimpleObjectProperty<LocalDate> end_date, IntegerProperty contractDuration, StringProperty remarks, StringProperty contractType) {
    this.contractor = contractor;
    this.natureOfContract = natureOfContract;
    this.user_dept = user_dept;
    this.value = value;
    this.valueRate = valueRate;
    this.start_date = start_date;
    //====== You need to add the end date here =====//
    this.end_date = end_date;
    this.contractDuration = contractDuration;
    this.remarks = remarks;
    this.contractType = contractType;
}