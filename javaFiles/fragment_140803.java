if(android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED))
    cacheDir=new File(android.os.Environment.getExternalStorageDirectory(),"MyCustomObject");
else
    cacheDir= getCacheDir();
if(!cacheDir.exists())
    cacheDir.mkdirs();

MyClass m = new MyClass("umer", "asif", true);
boolean result = m.saveObject(m);

if(result)
    Toast.makeText(this, "Saved object", Toast.LENGTH_LONG).show();
else
    Toast.makeText(this, "Error saving object", Toast.LENGTH_LONG).show();   

MyClass m = new MyClass();
MyClass c = m.getObject(this);

if(c!= null)
    Toast.makeText(this, "Retrieved object", Toast.LENGTH_LONG).show();
else
    Toast.makeText(this, "Error retrieving object", Toast.LENGTH_LONG).show();