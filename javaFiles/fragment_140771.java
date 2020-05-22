protected void doPost(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
        PrintWriter out = response.getWriter();


StringBuffer strJson = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                strJson.append(line);
            }

            Employee employee = new GsonBuilder().create().fromJson(strJson.toString(), Employee.class);


        int status=EmployeeDao.add(employee);

        if(status > 0){
            System.out.println("Record added successfully!");
        }else{
            System.out.println("Unable to add record");
        }
        out.close();
} catch(Exception ex) {
}
    }