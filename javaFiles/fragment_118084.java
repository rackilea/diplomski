String[] arr = null;
while (rs.next()) {
    String em = rs.getString("EM_ID");
    arr = em.split("\n");
    for (int i =0; i < arr.length; i++){
        System.out.println(arr[i]);
    }
}