List<Object[]> data = new ArrayList<>(useridArr.length);
for (int i = 0; i < useridArr.length; i++) {
    data.add(new Object[]{
                   useridArr[i], companyid, msg, announcerid, 0, 1, 
                   new java.util.Date().getTime()
             });
}