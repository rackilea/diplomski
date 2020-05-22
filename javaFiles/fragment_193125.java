try(InputStream content = httpresponse.getEntity().getContent())
        {
            //With apache
            String jsonResponse = IOUtils.toString(content, "UTF-8");
            System.out.println(jsonResponse);
        } catch (UnsupportedOperationException | IOException e) 
        {
            //Do something here, e.g. LOG
        }