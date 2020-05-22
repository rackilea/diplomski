// Get current ApplicationInfo to find .apk path
ApplicationInfo app = getApplicationContext().getApplicationInfo();
String filePath = app.sourceDir;

Intent intent = new Intent(Intent.ACTION_SEND);

// MIME of .apk is "application/vnd.android.package-archive".
// but Bluetooth does not accept this. Let's use "*/*" instead.
intent.setType("*/*");

// Only use Bluetooth to send .apk
intent.setPackage("com.android.bluetooth");

// Append file and send Intent
intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(filePath)));
startActivity(Intent.createChooser(intent, "Share app"));