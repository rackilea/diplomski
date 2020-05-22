catch (Exception e) {
         System.out.println(e);
         return null;
}

catch (Exception e) {
         System.out.println(e);
         throw new RuntimeException("DAO failed", e);
}