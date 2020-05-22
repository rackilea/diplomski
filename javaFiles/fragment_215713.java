Class myClass =                                                                        
  ClassLoader.getSystemClassLoader().loadClass("android.app.admin.DevicePolicyManager")

Object DPMInstance = myClass.newInstance();                                            

Method myMethod = myClass.getMethod("setPasswordQuality",                              
                                    new Class[] { ComponentName.class,                 
                                                  int.class });                        
myMethod.invoke(DPMInstance,                                                           
                new Object[] { myComponentName,                                        
                               PASSWORD_QUALITY_NUMERIC });