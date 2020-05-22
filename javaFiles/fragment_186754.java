class Score implements Serializable {
private String label;
private String field;
private String category;
private Integer valueInt;
private String value;
private Integer rank;
private Double percentile;
private String displayValue;

public Score() {
    this("", "", "", 0, "", 0, 0.0, "");
}

public Score(String label, String field,
             String category, Integer valueInt,
             String value, Integer rank,
             Double percentile, String displayValue) {
    this.label = label;
    this.field = field;
    this.category = category;
    this.valueInt = valueInt;
    this.value = value;
    this.rank = rank;
    this.percentile = percentile;
    this.displayValue = displayValue;
}

public String getLabel() {
    return label;
}

public void setLabel(String label) {
    this.label = label;
}

public String getField() {
    return field;
}

public void setField(String field) {
    this.field = field;
}

public String getCategory() {
    return category;
}

public void setCategory(String category) {
    this.category = category;
}

public Integer getValueInt() {
    return valueInt;
}

public void setValueInt(Integer valueInt) {
    this.valueInt = valueInt;
}

public String getValue() {
    return value;
}

public void setValue(String value) {
    this.value = value;
}

public Integer getRank() {
    return rank;
}

public void setRank(Integer rank) {
    this.rank = rank;
}

public Double getPercentile() {
    return percentile;
}

public void setPercentile(Double percentile) {
    this.percentile = percentile;
}

public String getDisplayValue() {
    return displayValue;
}

public void setDisplayValue(String displayValue) {
    this.displayValue = displayValue;
}
}

class TRNRating implements Serializable {

private String label;
private String field;
private String category;
private Integer valueInt;
private String value;
private Integer rank;
private Double percentile;
private String displayValue;

public TRNRating() {
    this("", "", "", 0, "", 0, 0.0, "");
}

public TRNRating(String label, String field,
                 String category, Integer valueInt,
                 String value, Integer rank,
                 Double percentile, String displayValue) {
    this.label = label;
    this.field = field;
    this.category = category;
    this.valueInt = valueInt;
    this.value = value;
    this.rank = rank;
    this.percentile = percentile;
    this.displayValue = displayValue;
}

public String getLabel() {
    return label;
}

public void setLabel(String label) {
    this.label = label;
}

public String getField() {
    return field;
}

public void setField(String field) {
    this.field = field;
}

public String getCategory() {
    return category;
}

public void setCategory(String category) {
    this.category = category;
}

public Integer getValueInt() {
    return valueInt;
}

public void setValueInt(Integer valueInt) {
    this.valueInt = valueInt;
}

public String getValue() {
    return value;
}

public void setValue(String value) {
    this.value = value;
}

public Integer getRank() {
    return rank;
}

public void setRank(Integer rank) {
    this.rank = rank;
}

public Double getPercentile() {
    return percentile;
}

public void setPercentile(Double percentile) {
    this.percentile = percentile;
}

public String getDisplayValue() {
    return displayValue;
}

public void setDisplayValue(String displayValue) {
    this.displayValue = displayValue;
}
}

class P2 implements Serializable {
private TRNRating trnRating;
private Score score;

public P2() {
    this(new TRNRating(), new Score());
}

public P2(TRNRating trnRating, Score score) {
    this.trnRating = trnRating;
    this.score = score;
}

public TRNRating getTrnRating() {
    return trnRating;
}

public void setTrnRating(TRNRating trnRating) {
    this.trnRating = trnRating;
}

public Score getScore() {
    return score;
}

public void setScore(Score score) {
    this.score = score;
}
}

class Stats implements Serializable {
private P2 p2;

public Stats() {
    this(new P2());
}

public Stats(P2 p2) {
    this.p2 = p2;
}
}

//You Need To Change Name Of This Class
class Response implements Serializable {
private String accountId;
private Integer platformId;
private String platformName;
private String platformNameLong;
private String epicUserHandle;
private Stats stats;

public Response() {
    this("", 0, "", "", "", new Stats());
}

public Response(String accountId, Integer platformId,
                String platformName, String platformNameLong,
                String epicUserHandle, Stats stats) {
    this.accountId = accountId;
    this.platformId = platformId;
    this.platformName = platformName;
    this.platformNameLong = platformNameLong;
    this.epicUserHandle = epicUserHandle;
    this.stats = stats;
}

public String getAccountId() {
    return accountId;
}

public void setAccountId(String accountId) {
    this.accountId = accountId;
}

public Integer getPlatformId() {
    return platformId;
}

public void setPlatformId(Integer platformId) {
    this.platformId = platformId;
}

public String getPlatformName() {
    return platformName;
}

public void setPlatformName(String platformName) {
    this.platformName = platformName;
}

public String getPlatformNameLong() {
    return platformNameLong;
}

public void setPlatformNameLong(String platformNameLong) {
    this.platformNameLong = platformNameLong;
}

public String getEpicUserHandle() {
    return epicUserHandle;
}

public void setEpicUserHandle(String epicUserHandle) {
    this.epicUserHandle = epicUserHandle;
}

public Stats getStats() {
    return stats;
}

public void setStats(Stats stats) {
    this.stats = stats;
}
}