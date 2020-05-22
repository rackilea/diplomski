if(body != null) {
                DataOutputStream writer = new DataOutputStream(conn.getOutputStream());
                byte[] data = body.toString().getBytes("UTF-8");
                writer.write(data);

                writer.flush();
                writer.close();
            }