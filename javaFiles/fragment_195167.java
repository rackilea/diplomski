@XStreamAlias("resultset_links")
public class ResultsetLinks {

@XStreamImplicit(itemFieldName="result")
protected List<Result> indivResult = new ArrayList<Result>();

  public ResultsetLinks() {

  }

  public List<Result> getResult()
  {

    return indivResult;
  }


  public  void setResult(List<Result> indiv_result)
    {

        this.indivResult =indiv_result;
    }

}