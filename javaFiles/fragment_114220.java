mSimpleFacebook.getProfile(new OnProfileRequestAdapter()
{
    @Override
    public void onComplete(Profile profile)
    {
        String id = profile.getId();
        String firstName = profile.getFirstName();
        String email = profile.getEmail();
        // ... and many more properties of profile ...
    }
});