public void isCheckEmail(final String email,final OnEmailCheckListener listener){
mAuth.fetchProvidersForEmail(email).addOnCompleteListener(new OnCompleteListener<ProviderQueryResult>()
{
    @Override
    public void onComplete(@NonNull Task<ProviderQueryResult> task)
    {
        boolean check = !task.getResult().getProviders().isEmpty();

        listener.onSucess(check);

    }
});

}