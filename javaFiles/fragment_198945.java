public class CustomUserCredentialsConnectionFactoryAdapter extends UserCredentialsConnectionFactoryAdapter {

    public CustomUserCredentialsConnectionFactoryAdapter(ConnectionFactory target){
        super();
        setTargetConnectionFactory(target);
    }

}