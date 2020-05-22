// first define your adapter as a field:
Nav_adapter adapter;

// then on your event
public void onEventMainThread(PersonDetails event){
   mNomeCognome = event.mNomeCognome;
   mEmail = event.mEmail;
   adapter.setNewValues(mNomeCognome, mEmail);
}