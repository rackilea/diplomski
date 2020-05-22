@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "activateService")
public class ActivateService implements Serializable  {

@JsonView(View.Editable.class)
public String mWalletToken;
@JsonView(View.Editable.class)
public String topMerchantEMPID;
@JsonView(View.Editable.class)
public String serviceCategory;
  }