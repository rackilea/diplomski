public class AccountAdapter extends XmlAdapter<AccountRef, Account>
{
    @Override
    public AccountRef marshal(Account v) throws Exception 
    {   
        AccountRef ref = new AccountRef();
        ref.id = v.id;
        return ref;
    }

    @Override
    public Account unmarshal(AccountRef v) throws Exception 
    {
        // Implement if you need to deserialize
    }
}