@XStreamAlias("apiresponse")
public class ApiResponse {

@XStreamAlias("resultset_links")
protected ResultsetLinks rlinks;


public ApiResponse() {

}

public ResultsetLinks getRlinks()
{
    return rlinks;
}

public void setRlinks(ResultsetLinks rlinks)
  {
    this.rlinks=rlinks;
  }