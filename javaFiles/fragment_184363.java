import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Intents;
import android.app.Activity;
import android.content.Intent;

public class Contact{

    public static void addContact(Activity pyActivity, String name, String phone, String email){
        Intent i = new Intent(Intent.ACTION_INSERT);
        i.setType(Contacts.CONTENT_TYPE);
        i.putExtra(Intents.Insert.NAME, name);
        i.putExtra(Intents.Insert.PHONE, phone);
        i.putExtra(Intents.Insert.EMAIL, email);
        pyActivity.startActivity(i);
    }

}