import com.google.android.gms.instantapps.InstantApps;
import android.content.Intent;
import android.net.Uri;

Intent postInstallIntent = new Intent(Intent.ACTION_VIEW,
       Uri.parse("https://install-api.instantappsample.com/")).
       addCategory(Intent.CATEGORY_BROWSABLE);

InstantApps.showInstallPrompt((Activity)getContext(),//'this' if calling from main
       postInstallIntent,7,"InstallApiActivity");