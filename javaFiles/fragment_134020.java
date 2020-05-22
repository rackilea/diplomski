@JsonDeserialize(as = CipherRequestBean.class)
public class CipherRequestBean extends AbstractCipherRequestBean{
...
}

@JsonDeserialize(as = CipherMultRequestBean.class)
public class CipherMultRequestBean extends AbstractCipherRequestBean {
private List<String> b64Data;
...
}