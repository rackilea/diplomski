StringWriter writer = new StringWriter();
            InputStream resourceStream = this.getClass().getResourceAsStream("/sql/schema.sql");
            if(resourceStream == null ) {
                throw new FileNotFoundException("schema not found");
            }
            IOUtils.copy(resourceStream, writer);
            Handle handle = null;
            try {
                handle = dbi.open();
                handle.execute(writer.toString());
                handle.commit();
            } finally {
                handle.close();
                if(resourceStream != null) {
                    resourceStream.close();
                }
                writer.close();
            }