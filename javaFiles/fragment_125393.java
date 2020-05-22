In Java file:
Intent iskype = new Intent("android.intent.action.VIEW"); 
iskype.setData(Uri.parse("skype:PassportCard")); 
act.startActivity(iskype);

In AndroidManifast.xml
<intent-filter> 
      <category android:name="android.intent.category.DEFAULT" />
      <action android:name="android.intent.action.VIEW" />                     
      <data android:scheme="skype" /> 
</intent-filter>