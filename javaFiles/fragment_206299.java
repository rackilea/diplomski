import com.fasterxml.jackson.annotation.JsonProperty;

class RuleModel
{
  private long ruleId;
  @JsonProperty("Formula") private Formula formula;
}

class Formula
{
  private String ruleAggregates;
  private List<String> fields;
  private List<FormulaModel> Children;
}

class FormulaModel
{
  @JsonProperty("Formula") private Formula formula;
}