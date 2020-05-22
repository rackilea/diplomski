String connectionString = String.format("DefaultEndpointsProtocol=http;AccountName=%s;AccountKey=%s", ACCOUNT_NAME, ACCOUNT_KEY);
        CloudStorageAccount account = CloudStorageAccount.parse(connectionString);
        CloudBlobContainer container = null;

        CloudBlobClient client = account.createCloudBlobClient();

        container = client.getContainerReference("blobcontainer");

        CloudBlockBlob blob = container.getBlockBlobReference("6M_FY2018-19_InvestorUpdate.pdf");

        URL uri =new URL("http://irpages2.equitystory.com/download/companies/douglasgmbh/Pres_web/6M_FY2018-19_InvestorUpdate.pdf");

        InputStream is=uri.openStream();

        BlobOutputStream blobOutputStream = blob.openOutputStream();

        int next = is.read();
        while (next != -1) {
            blobOutputStream.write(next);
            next = is.read();
        }
        blobOutputStream.close();