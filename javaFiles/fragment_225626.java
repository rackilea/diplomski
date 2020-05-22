public static void main(String[] args) {
  AppPreferences preferences = new AppPreferences();
  for(int i=1;i <= 7;i++){
    for(int j = 1;j <=4;j++){
      try {
        String func ="getD"+i+"t"+j+"h";
        Method method = AppPreferences.class.getMethod(func);
        Object result = method.invoke(preferences);
        System.out.print(result);
      } catch (Exception e) {
        System.err.print(".");
      }
    }
}