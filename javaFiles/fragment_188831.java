// Create the form content
          OutputStream out = conn.getOutputStream();
          Writer writer = new OutputStreamWriter(out, "UTF-8");
          for (int i = 0; i < paramName.length; i++) {
            writer.write(paramName[i]);
            writer.write("=");
            writer.write(URLEncoder.encode(paramVal[i], "UTF-8"));
            writer.write("&");
          }
          writer.close();
          out.close();

          if (conn.getResponseCode() != 200) {
            throw new IOException(conn.getResponseMessage());
          }

          // Buffer the result into a string
          BufferedReader rd = new BufferedReader(
              new InputStreamReader(conn.getInputStream()));
          StringBuilder sb = new StringBuilder();
          String line;
          while ((line = rd.readLine()) != null) {
            sb.append(line);
          }
          rd.close();

          conn.disconnect();
          return sb.toString();
        }