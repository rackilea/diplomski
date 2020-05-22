try {
    for (String val : list) {
        try {
          Thread.sleep(25);
        } catch (Exception e) {
        }
    }
} catch (Exception e) {
    e.printStackTrace();
}