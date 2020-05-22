-----------------------------------com.example.ResultWrapper.java------

            package com.example;

            @JsonInclude(JsonInclude.Include.NON_NULL)
            @Generated("org.jsonschema2pojo")
            @JsonPropertyOrder({
            "code",
            "results"
            })
            public class ResultWrapper {

            @JsonProperty("code")
            private long code;
            @JsonProperty("results")
            private List<Result> results = new ArrayList<Result>();

            /**
            * 
            * @return
            * The code
            */
            @JsonProperty("code")
            public long getCode() {
            return code;
            }

            /**
            * 
            * @param code
            * The code
            */
            @JsonProperty("code")
            public void setCode(long code) {
            this.code = code;
            }

            /**
            * 
            * @return
            * The results
            */
            @JsonProperty("results")
            public List<Result> getResults() {
            return results;
            }

            /**
            * 
            * @param results
            * The results
            */
            @JsonProperty("results")
            public void setResults(List<Result> results) {
            this.results = results;
            }

            @JsonAnyGetter
            public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
            }

            @JsonAnySetter
            public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
            }

            }

             -----------------------------------com.example.Result.java-----------------------------------

            package com.example;


            @JsonInclude(JsonInclude.Include.NON_NULL)
            @Generated("org.jsonschema2pojo")
            @JsonPropertyOrder({
            "_id",
            "ExchangeListInfo",
            "RedeemCall",
            "MsdInformation",
            "SecInformation",
            "ConversionBasic",
            "IncomeInformation",
            "version",
            "id",
            "cloudstamp"
            })
            public class Result {

            @JsonProperty("_id")
            private String Id;
            @JsonProperty("ExchangeListInfo")
            private com.example.ExchangeListInfo ExchangeListInfo;
            @JsonProperty("RedeemCall")
            private com.example.RedeemCall RedeemCall;
            @JsonProperty("MsdInformation")
            private com.example.MsdInformation MsdInformation;
            @JsonProperty("SecInformation")
            private com.example.SecInformation SecInformation;
            @JsonProperty("ConversionBasic")
            private com.example.ConversionBasic ConversionBasic;
            @JsonProperty("IncomeInformation")
            private com.example.IncomeInformation IncomeInformation;
            @JsonProperty("version")
            private long version;
            @JsonProperty("id")
            private long id;
            @JsonProperty("cloudstamp")
            private String cloudstamp;


            @JsonProperty("_id")
            public String getId() {
            return Id;
            }


            @JsonProperty("_id")
            public void setId(String Id) {
            this.Id = Id;
            }


            @JsonProperty("ExchangeListInfo")
            public com.example.ExchangeListInfo getExchangeListInfo() {
            return ExchangeListInfo;
            }



            @JsonProperty("ExchangeListInfo")
            public void setExchangeListInfo(com.example.ExchangeListInfo ExchangeListInfo) {
            this.ExchangeListInfo = ExchangeListInfo;
            }


            @JsonProperty("RedeemCall")
            public com.example.RedeemCall getRedeemCall() {
            return RedeemCall;
            }


            @JsonProperty("RedeemCall")
            public void setRedeemCall(com.example.RedeemCall RedeemCall) {
            this.RedeemCall = RedeemCall;
            }


            @JsonProperty("MsdInformation")
            public com.example.MsdInformation getMsdInformation() {
            return MsdInformation;
            }



            @JsonProperty("MsdInformation")
            public void setMsdInformation(com.example.MsdInformation MsdInformation) {
            this.MsdInformation = MsdInformation;
            }


            @JsonProperty("SecInformation")
            public com.example.SecInformation getSecInformation() {
            return SecInformation;
            }


            @JsonProperty("SecInformation")
            public void setSecInformation(com.example.SecInformation SecInformation) {
            this.SecInformation = SecInformation;
            }


            @JsonProperty("ConversionBasic")
            public com.example.ConversionBasic getConversionBasic() {
            return ConversionBasic;
            }


            @JsonProperty("ConversionBasic")
            public void setConversionBasic(com.example.ConversionBasic ConversionBasic) {
            this.ConversionBasic = ConversionBasic;
            }


            @JsonProperty("IncomeInformation")
            public com.example.IncomeInformation getIncomeInformation() {
            return IncomeInformation;
            }



            @JsonProperty("IncomeInformation")
            public void setIncomeInformation(com.example.IncomeInformation IncomeInformation) {
            this.IncomeInformation = IncomeInformation;
            }


            @JsonProperty("version")
            public long getVersion() {
            return version;
            }


            @JsonProperty("version")
            public void setVersion(long version) {
            this.version = version;
            }


            @JsonProperty("id")
            public long getId() {
            return id;
            }



            @JsonProperty("id")
            public void setId(long id) {
            this.id = id;
            }


            @JsonProperty("cloudstamp")
            public String getCloudstamp() {
            return cloudstamp;
            }


            @JsonProperty("cloudstamp")
            public void setCloudstamp(String cloudstamp) {
            this.cloudstamp = cloudstamp;
            }

            @JsonAnyGetter
            public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
            }

            @JsonAnySetter
            public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
            }

            }

    -----------------------com.example.ConversionBasic.java-----------
            package com.example;
            @JsonInclude(JsonInclude.Include.NON_NULL)
            @Generated("org.jsonschema2pojo")
            @JsonPropertyOrder({
            "ConversionMandatoryFlag"
            })
            public class ConversionBasic {

            @JsonProperty("ConversionMandatoryFlag")
            private boolean ConversionMandatoryFlag;


            @JsonProperty("ConversionMandatoryFlag")
            public boolean isConversionMandatoryFlag() {
            return ConversionMandatoryFlag;
            }

            /**
            * 
            * @param ConversionMandatoryFlag
            * The ConversionMandatoryFlag
            */
            @JsonProperty("ConversionMandatoryFlag")
            public void setConversionMandatoryFlag(boolean ConversionMandatoryFlag) {
            this.ConversionMandatoryFlag = ConversionMandatoryFlag;
            }

            @JsonAnyGetter
            public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
            }

            @JsonAnySetter
            public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
            }

            }
            -----------------------------------com.example.ExchangeListInfo.java----

            package com.example;


            @JsonInclude(JsonInclude.Include.NON_NULL)
            @Generated("org.jsonschema2pojo")
            @JsonPropertyOrder({
            "InstrumentListingLevel",
            "SettlementCurrency"
            })
            public class ExchangeListInfo {

            @JsonProperty("InstrumentListingLevel")
            private String InstrumentListingLevel;
            @JsonProperty("SettlementCurrency")
            private String SettlementCurrency;


            @JsonProperty("InstrumentListingLevel")
            public String getInstrumentListingLevel() {
            return InstrumentListingLevel;
            }


            @JsonProperty("InstrumentListingLevel")
            public void setInstrumentListingLevel(String InstrumentListingLevel) {
            this.InstrumentListingLevel = InstrumentListingLevel;
            }


            @JsonProperty("SettlementCurrency")
            public String getSettlementCurrency() {
            return SettlementCurrency;
            }


            @JsonProperty("SettlementCurrency")
            public void setSettlementCurrency(String SettlementCurrency) {
            this.SettlementCurrency = SettlementCurrency;
            }

            @JsonAnyGetter
            public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
            }

            @JsonAnySetter
            public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
            }

            }
            -----------------------------------com.example.IncomeInformation.java-------

            package com.example;


            @JsonInclude(JsonInclude.Include.NON_NULL)
            @Generated("org.jsonschema2pojo")
            @JsonPropertyOrder({
            "AccrualMethod",
            "NextPayDate",
            "CouponDividendRate",
            "CouponDividendType",
            "CouponDividendCurrency",
            "CouponDividendFrequency",
            "LastPayDate",
            "FirstPayDate",
            "PreviousPaymentDate",
            "DatedDate",
            "IsPayInKind",
            "UnadjustedPreviousCouponPayDat"
            })
            public class IncomeInformation {

            @JsonProperty("AccrualMethod")
            private String AccrualMethod;
            @JsonProperty("NextPayDate")
            private String NextPayDate;
            @JsonProperty("CouponDividendRate")
            private double CouponDividendRate;
            @JsonProperty("CouponDividendType")
            private String CouponDividendType;
            @JsonProperty("CouponDividendCurrency")
            private String CouponDividendCurrency;
            @JsonProperty("CouponDividendFrequency")
            private long CouponDividendFrequency;
            @JsonProperty("LastPayDate")
            private String LastPayDate;
            @JsonProperty("FirstPayDate")
            private String FirstPayDate;
            @JsonProperty("PreviousPaymentDate")
            private String PreviousPaymentDate;
            @JsonProperty("DatedDate")
            private String DatedDate;
            @JsonProperty("IsPayInKind")
            private boolean IsPayInKind;
            @JsonProperty("UnadjustedPreviousCouponPayDat")
            private String UnadjustedPreviousCouponPayDat;
            @JsonProperty("AccrualMethod")
            public String getAccrualMethod() {
            return AccrualMethod;
            }


            @JsonProperty("AccrualMethod")
            public void setAccrualMethod(String AccrualMethod) {
            this.AccrualMethod = AccrualMethod;
            }

            @JsonProperty("NextPayDate")
            public String getNextPayDate() {
            return NextPayDate;
            }


            @JsonProperty("NextPayDate")
            public void setNextPayDate(String NextPayDate) {
            this.NextPayDate = NextPayDate;
            }
            @JsonProperty("CouponDividendRate")
            public double getCouponDividendRate() {
            return CouponDividendRate;
            }
            @JsonProperty("CouponDividendRate")
            public void setCouponDividendRate(double CouponDividendRate) {
            this.CouponDividendRate = CouponDividendRate;
            }

            @JsonProperty("CouponDividendType")
            public String getCouponDividendType() {
            return CouponDividendType;
            }

            @JsonProperty("CouponDividendType")
            public void setCouponDividendType(String CouponDividendType) {
            this.CouponDividendType = CouponDividendType;
            }

            @JsonProperty("CouponDividendCurrency")
            public String getCouponDividendCurrency() {
            return CouponDividendCurrency;
            }
            @JsonProperty("CouponDividendCurrency")
            public void setCouponDividendCurrency(String CouponDividendCurrency) {
            this.CouponDividendCurrency = CouponDividendCurrency;
            }

            @JsonProperty("CouponDividendFrequency")
            public long getCouponDividendFrequency() {
            return CouponDividendFrequency;
            }

            @JsonProperty("CouponDividendFrequency")
            public void setCouponDividendFrequency(long CouponDividendFrequency) {
            this.CouponDividendFrequency = CouponDividendFrequency;
            }

            @JsonProperty("LastPayDate")
            public String getLastPayDate() {
            return LastPayDate;
            }

            @JsonProperty("LastPayDate")
            public void setLastPayDate(String LastPayDate) {
            this.LastPayDate = LastPayDate;
            }

            @JsonProperty("FirstPayDate")
            public String getFirstPayDate() {
            return FirstPayDate;
            }

            @JsonProperty("FirstPayDate")
            public void setFirstPayDate(String FirstPayDate) {
            this.FirstPayDate = FirstPayDate;
            }

            @JsonProperty("PreviousPaymentDate")
            public String getPreviousPaymentDate() {
            return PreviousPaymentDate;
            }

            @JsonProperty("PreviousPaymentDate")
            public void setPreviousPaymentDate(String PreviousPaymentDate) {
            this.PreviousPaymentDate = PreviousPaymentDate;
            }

            @JsonProperty("DatedDate")
            public String getDatedDate() {
            return DatedDate;
            }

            @JsonProperty("DatedDate")
            public void setDatedDate(String DatedDate) {
            this.DatedDate = DatedDate;
            }


            @JsonProperty("IsPayInKind")
            public boolean isIsPayInKind() {
            return IsPayInKind;
            }


            @JsonProperty("IsPayInKind")
            public void setIsPayInKind(boolean IsPayInKind) {
            this.IsPayInKind = IsPayInKind;
            }


            @JsonProperty("UnadjustedPreviousCouponPayDat")
            public String getUnadjustedPreviousCouponPayDat() {
            return UnadjustedPreviousCouponPayDat;
            }


            @JsonProperty("UnadjustedPreviousCouponPayDat")
            public void setUnadjustedPreviousCouponPayDat(String UnadjustedPreviousCouponPayDat) {
            this.UnadjustedPreviousCouponPayDat = UnadjustedPreviousCouponPayDat;
            }

            @JsonAnyGetter
            public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
            }

            @JsonAnySetter
            public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
            }

            }
            -----------------------------------com.example.MsdInformation.java------

            package com.example;

            @JsonInclude(JsonInclude.Include.NON_NULL)
            @Generated("org.jsonschema2pojo")
            @JsonPropertyOrder({
            "MSDCallPutFlag",
            "MSDMinimumDenomination",
            "MSDCouponFrequency",
            "MSDBondForm",
            "MSDSovDebtFlag",
            "MSDDatedDt",
            "MSDMaturityDt"
            })
            public class MsdInformation {

            @JsonProperty("MSDCallPutFlag")
            private String MSDCallPutFlag;
            @JsonProperty("MSDMinimumDenomination")
            private double MSDMinimumDenomination;
            @JsonProperty("MSDCouponFrequency")
            private String MSDCouponFrequency;
            @JsonProperty("MSDBondForm")
            private String MSDBondForm;
            @JsonProperty("MSDSovDebtFlag")
            private boolean MSDSovDebtFlag;
            @JsonProperty("MSDDatedDt")
            private String MSDDatedDt;
            @JsonProperty("MSDMaturityDt")
            private String MSDMaturityDt;
            @JsonIgnore
            private Map<String, Object> additionalProperties = new HashMap<String, Object>();


            @JsonProperty("MSDCallPutFlag")
            public String getMSDCallPutFlag() {
            return MSDCallPutFlag;
            }

            @JsonProperty("MSDCallPutFlag")
            public void setMSDCallPutFlag(String MSDCallPutFlag) {
            this.MSDCallPutFlag = MSDCallPutFlag;
            }


            @JsonProperty("MSDMinimumDenomination")
            public double getMSDMinimumDenomination() {
            return MSDMinimumDenomination;
            }


            @JsonProperty("MSDMinimumDenomination")
            public void setMSDMinimumDenomination(double MSDMinimumDenomination) {
            this.MSDMinimumDenomination = MSDMinimumDenomination;
            }


            @JsonProperty("MSDCouponFrequency")
            public String getMSDCouponFrequency() {
            return MSDCouponFrequency;
            }

            @JsonProperty("MSDCouponFrequency")
            public void setMSDCouponFrequency(String MSDCouponFrequency) {
            this.MSDCouponFrequency = MSDCouponFrequency;
            }


            @JsonProperty("MSDBondForm")
            public String getMSDBondForm() {
            return MSDBondForm;
            }


            @JsonProperty("MSDBondForm")
            public void setMSDBondForm(String MSDBondForm) {
            this.MSDBondForm = MSDBondForm;
            }


            @JsonProperty("MSDSovDebtFlag")
            public boolean isMSDSovDebtFlag() {
            return MSDSovDebtFlag;
            }


            @JsonProperty("MSDSovDebtFlag")
            public void setMSDSovDebtFlag(boolean MSDSovDebtFlag) {
            this.MSDSovDebtFlag = MSDSovDebtFlag;
            }


            @JsonProperty("MSDDatedDt")
            public String getMSDDatedDt() {
            return MSDDatedDt;
            }


            @JsonProperty("MSDDatedDt")
            public void setMSDDatedDt(String MSDDatedDt) {
            this.MSDDatedDt = MSDDatedDt;
            }


            @JsonProperty("MSDMaturityDt")
            public String getMSDMaturityDt() {
            return MSDMaturityDt;
            }


            @JsonProperty("MSDMaturityDt")
            public void setMSDMaturityDt(String MSDMaturityDt) {
            this.MSDMaturityDt = MSDMaturityDt;
            }

            @JsonAnyGetter
            public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
            }

            @JsonAnySetter
            public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
            }

            }
            -----------------------------------com.example.RedeemCall.java----------

            package com.example;

            @JsonInclude(JsonInclude.Include.NON_NULL)
            @Generated("org.jsonschema2pojo")
            @JsonPropertyOrder({
            "IsMWholeCall"
            })
            public class RedeemCall {

            @JsonProperty("IsMWholeCall")
            private boolean IsMWholeCall;
            @JsonIgnore
            private Map<String, Object> additionalProperties = new HashMap<String, Object>();


            @JsonProperty("IsMWholeCall")
            public boolean isIsMWholeCall() {
            return IsMWholeCall;
            }


            @JsonProperty("IsMWholeCall")
            public void setIsMWholeCall(boolean IsMWholeCall) {
            this.IsMWholeCall = IsMWholeCall;
            }

            @JsonAnyGetter
            public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
            }

            @JsonAnySetter
            public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
            }

            }

            -----------------------------------com.example.SecInformation.java------

            package com.example;

            @JsonInclude(JsonInclude.Include.NON_NULL)
            @Generated("org.jsonschema2pojo")
            @JsonPropertyOrder({
            "PutFreq",
            "ItDivFreq",
            "ItBasDysTyp",
            "PuTyp"
            })
            public class SecInformation {

            @JsonProperty("PutFreq")
            private String PutFreq;
            @JsonProperty("ItDivFreq")
            private String ItDivFreq;
            @JsonProperty("ItBasDysTyp")
            private String ItBasDysTyp;
            @JsonProperty("PuTyp")
            private String PuTyp;
            @JsonIgnore
            private Map<String, Object> additionalProperties = new HashMap<String, Object>();


            @JsonProperty("PutFreq")
            public String getPutFreq() {
            return PutFreq;
            }


            @JsonProperty("PutFreq")
            public void setPutFreq(String PutFreq) {
            this.PutFreq = PutFreq;
            }


            @JsonProperty("ItDivFreq")
            public String getItDivFreq() {
            return ItDivFreq;
            }

            @JsonProperty("ItDivFreq")
            public void setItDivFreq(String ItDivFreq) {
            this.ItDivFreq = ItDivFreq;
            }


            @JsonProperty("ItBasDysTyp")
            public String getItBasDysTyp() {
            return ItBasDysTyp;
            }


            @JsonProperty("ItBasDysTyp")
            public void setItBasDysTyp(String ItBasDysTyp) {
            this.ItBasDysTyp = ItBasDysTyp;
            }


            @JsonProperty("PuTyp")
            public String getPuTyp() {
            return PuTyp;
            }

            @JsonProperty("PuTyp")
            public void setPuTyp(String PuTyp) {
            this.PuTyp = PuTyp;
            }

            @JsonAnyGetter
            public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
            }

            @JsonAnySetter
            public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
            }

            }