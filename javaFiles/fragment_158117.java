Use JsonObject like below:

JSONObject job=new JSONObject();
        job.put("email",emailId);
        job.put("pwd",pwd);
writer.write(job.tostring());